package com.numble.visitor.service;

import com.numble.visitor.service.event.SiteVisited;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class SiteVisitorStatisticSearchServiceTest {
//    @Autowired
//    private SiteVisitorStatisticSearchService siteVisitorStatisticSearchService;
//
//    @Autowired
//    private SiteVisitorConsumerService siteVisitorConsumerService;

    @Test
    public void searchSiteVisitorStatisticTest() {
//        //given
//        final String testSiteRootPath = "test";
//
//        final LocalDateTime now = LocalDateTime.now();
//        final SiteVisited siteVisited = new SiteVisited(testSiteRootPath, now);
//
//        siteVisitorConsumerService.increaseVisitorCount(siteVisited);
//        siteVisitorConsumerService.increaseVisitorCount(siteVisited);
//        siteVisitorConsumerService.increaseVisitorCount(siteVisited);
//
//        //when
//        final SiteVisitorStatisticDto siteVisitorStatistic = siteVisitorStatisticSearchService.searchSiteVisitorStatistic(testSiteRootPath);
//
//        //then
//        Assertions.assertEquals(0, BigDecimal.valueOf(3).compareTo(siteVisitorStatistic.getDailyVisitorCount()));
//        Assertions.assertEquals(0, BigDecimal.valueOf(3).compareTo(siteVisitorStatistic.getWeeklyVisitorCount()));
//        Assertions.assertEquals(0, BigDecimal.valueOf(3).compareTo(siteVisitorStatistic.getTotalVisitorCount()));
    }
}
