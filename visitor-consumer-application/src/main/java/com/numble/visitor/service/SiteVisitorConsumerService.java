package com.numble.visitor.service;

import com.numble.visitor.domain.entity.PeriodType;
import com.numble.visitor.domain.entity.Site;
import com.numble.visitor.domain.entity.SiteVisitorStatistic;
import com.numble.visitor.domain.repository.SiteRepository;
import com.numble.visitor.domain.repository.SiteVisitorStatisticRepository;
import com.numble.visitor.holder.ObjectMapperHolder;
import com.numble.visitor.service.event.SiteVisited;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class SiteVisitorConsumerService {
    private static final String SITE_VISITED_TOPIC_NAME = "siteVisited";

    private static final String SITE_VISITOR_COUNT_LOCK_NAME = "site_visitor_count";

    private final SiteRepository siteRepository;
    private final RedissonClient redissonClient;
    private final SiteVisitorStatisticRepository siteVisitorStatisticRepository;

    @Transactional
    @KafkaListener(id = "visitor-count-increase-consumer", topics = SITE_VISITED_TOPIC_NAME, concurrency = "5")
    public void increaseVisitorCount(String sitedVisitedJson) {
        final SiteVisited siteVisited = ObjectMapperHolder.readValue(sitedVisitedJson, SiteVisited.class);

        final String siteRootPath = siteVisited.getSiteRootPath();
        final LocalDateTime visitedDateTime = siteVisited.getVisitedDateTime();

        final Site site = siteRepository.findSiteBySiteRootPath(siteRootPath)
                .orElseGet(() -> siteRepository.save(Site.builder()
                        .siteRootPath(siteRootPath)
                        .build()));

        final RLock lock = redissonClient.getLock(SITE_VISITOR_COUNT_LOCK_NAME);

        try {
            lock.lock();
            increaseVisitorCountByEachPeriodType(site, visitedDateTime);
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    private void increaseVisitorCountByEachPeriodType(Site site, LocalDateTime visitedDateTime) {
        Arrays.stream(PeriodType.values())
                .forEach(periodType -> siteVisitorStatisticRepository.findSiteVisitorStatisticByStandardDateTimeAndSiteAndPeriodType(
                                periodType.calculateStandardDateTime(visitedDateTime), site, periodType)
                        .ifPresentOrElse(SiteVisitorStatistic::increaseVisitorCount, () -> createNewSiteVisitorStatistic(site, periodType, visitedDateTime)));
    }

    private void createNewSiteVisitorStatistic(Site site, PeriodType periodType, LocalDateTime visitedDateTime) {
        siteVisitorStatisticRepository.save(SiteVisitorStatistic.builder()
                .site(site)
                .periodType(periodType)
                .dateTime(visitedDateTime)
                .visitorCount(BigDecimal.ONE)
                .build());
    }
}
