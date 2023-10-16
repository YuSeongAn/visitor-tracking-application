package com.numble.visitor.service.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class SiteVisitorStatisticDto {
    private final String siteRootPath;
    private final BigDecimal dailyVisitorCount;
    private final BigDecimal weeklyVisitorCount;
    private final BigDecimal totalVisitorCount;
}
