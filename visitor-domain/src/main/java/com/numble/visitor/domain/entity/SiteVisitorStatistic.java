package com.numble.visitor.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@Table(name = "SiteVisitorStatistic")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SiteVisitorStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "siteId", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Site site;

    @Column
    @Enumerated(EnumType.STRING)
    private PeriodType periodType;

    @Column
    private LocalDateTime standardDateTime;

    @Column
    private BigDecimal visitorCount;

    @Builder
    public SiteVisitorStatistic(Site site, PeriodType periodType, LocalDateTime dateTime, BigDecimal visitorCount) {
        this.site = site;
        this.periodType = periodType;
        this.standardDateTime = periodType.calculateStandardDateTime(dateTime);
        this.visitorCount = Objects.isNull(visitorCount) ? BigDecimal.ZERO : visitorCount;
    }

    public void increaseVisitorCount() {
        visitorCount = visitorCount.add(BigDecimal.ONE);
    }
}
