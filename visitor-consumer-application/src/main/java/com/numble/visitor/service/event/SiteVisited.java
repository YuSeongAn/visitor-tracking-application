package com.numble.visitor.service.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SiteVisited {
    private String siteRootPath;
    private LocalDateTime visitedDateTime;
}
