package com.numble.visitor.service;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SiteVisited {
    private String siteRootPath;
    private LocalDateTime visitedDateTime;
}
