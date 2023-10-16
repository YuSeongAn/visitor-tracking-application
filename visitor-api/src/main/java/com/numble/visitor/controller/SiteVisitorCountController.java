package com.numble.visitor.controller;

import com.numble.visitor.controller.dto.ApiResponse;
import com.numble.visitor.service.SiteVisitorProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SiteVisitorCountController {

    private final SiteVisitorProducerService siteVisitorProducerService;

    @PostMapping("/site/visitor")
    public ApiResponse<Void> increaseSiteVisitor(@RequestParam String siteRootPath) {
        siteVisitorProducerService.publishSiteVisitedEvent(siteRootPath);

        return ApiResponse.success();
    }
}
