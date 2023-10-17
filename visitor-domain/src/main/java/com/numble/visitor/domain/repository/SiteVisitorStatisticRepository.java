package com.numble.visitor.domain.repository;

import com.numble.visitor.domain.entity.PeriodType;
import com.numble.visitor.domain.entity.Site;
import com.numble.visitor.domain.entity.SiteVisitorStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SiteVisitorStatisticRepository extends JpaRepository<SiteVisitorStatistic, Long> {
    Optional<SiteVisitorStatistic> findSiteVisitorStatisticByStandardDateTimeAndSiteAndPeriodType(LocalDateTime dateTime, Site site, PeriodType periodType);
}
