package com.numble.visitor.domain.repository;

import com.numble.visitor.domain.entity.PeriodType;
import com.numble.visitor.domain.entity.Site;
import com.numble.visitor.domain.entity.SiteVisitorStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.util.Optional;

public interface SiteVisitorStatisticRepository extends JpaRepository<SiteVisitorStatistic, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<SiteVisitorStatistic> findSiteVisitorStatisticWithLockByStandardDateTimeAndSiteAndPeriodType(LocalDateTime dateTime, Site site, PeriodType periodType);

    Optional<SiteVisitorStatistic> findSiteVisitorStatisticByStandardDateTimeAndSiteAndPeriodType(LocalDateTime dateTime, Site site, PeriodType periodType);
}
