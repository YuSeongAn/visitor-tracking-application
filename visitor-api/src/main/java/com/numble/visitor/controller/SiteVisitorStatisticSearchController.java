package com.numble.visitor.controller;

import com.numble.visitor.controller.dto.ApiResponse;
import com.numble.visitor.service.SiteVisitorStatisticSearchService;
import com.numble.visitor.service.dto.SiteVisitorStatisticDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SiteVisitorStatisticSearchController {
    private final SiteVisitorStatisticSearchService siteVisitorStatisticSearchService;

    @GetMapping("/site/visitor-statistics")
    public ApiResponse<SiteVisitorStatisticDto> searchSiteVisitorStatistic(@RequestParam String siteRootPath) {
        final SiteVisitorStatisticDto siteVisitorStatistic = siteVisitorStatisticSearchService.searchSiteVisitorStatistic(siteRootPath);

        return ApiResponse.success(siteVisitorStatistic);
    }
}