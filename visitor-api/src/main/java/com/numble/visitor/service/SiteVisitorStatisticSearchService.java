package com.numble.visitor.service;

import com.numble.visitor.exception.SiteNotFoundException;
import com.numble.visitor.exception.SiteStatisticNotFoundException;
import com.numble.visitor.service.dto.SiteVisitorStatisticDto;
import com.numble.visitor.domain.entity.PeriodType;
import com.numble.visitor.domain.entity.Site;
import com.numble.visitor.domain.entity.SiteVisitorStatistic;
import com.numble.visitor.domain.repository.SiteRepository;
import com.numble.visitor.domain.repository.SiteVisitorStatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SiteVisitorStatisticSearchService {
    private final SiteRepository siteRepository;
    private final SiteVisitorStatisticRepository siteVisitorStatisticRepository;

    public SiteVisitorStatisticDto searchSiteVisitorStatistic(String siteRootPath) {
        final Site site = siteRepository.findSiteBySiteRootPath(siteRootPath)
                .orElseThrow(() -> new SiteNotFoundException("not found site path"));

        final LocalDateTime now = LocalDateTime.now();

        final SiteVisitorStatistic dailySiteVisitorStatistic = siteVisitorStatisticRepository.findSiteVisitorStatisticByStandardDateTimeAndSiteAndPeriodType(
                        PeriodType.DAILY.calculateStandardDateTime(now), site, PeriodType.DAILY)
                .orElseThrow(() -> new SiteStatisticNotFoundException("not found site's statistic"));

        final SiteVisitorStatistic weeklySiteVisitorStatistic = siteVisitorStatisticRepository.findSiteVisitorStatisticByStandardDateTimeAndSiteAndPeriodType(
                        PeriodType.WEEKLY.calculateStandardDateTime(now), site, PeriodType.WEEKLY)
                .orElseThrow(() -> new SiteStatisticNotFoundException("not found site's statistic"));

        final SiteVisitorStatistic totalSiteVisitorStatistic = siteVisitorStatisticRepository.findSiteVisitorStatisticByStandardDateTimeAndSiteAndPeriodType(
                        PeriodType.ALL.calculateStandardDateTime(now), site, PeriodType.ALL)
                .orElseThrow(() -> new SiteStatisticNotFoundException("not found site's statistic"));

        return SiteVisitorStatisticDto.builder()
                .siteRootPath(site.getSiteRootPath())
                .dailyVisitorCount(dailySiteVisitorStatistic.getVisitorCount())
                .weeklyVisitorCount(weeklySiteVisitorStatistic.getVisitorCount())
                .totalVisitorCount(totalSiteVisitorStatistic.getVisitorCount())
                .build();
    }
}
