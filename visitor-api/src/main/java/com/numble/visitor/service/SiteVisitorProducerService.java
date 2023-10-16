package com.numble.visitor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.numble.visitor.holder.ObjectMapperHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SiteVisitorProducerService {
    private static final String SITE_VISITED_TOPIC_NAME = "siteVisited";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishSiteVisitedEvent(String siteRootPath) {
        final SiteVisited siteVisitedEvent = SiteVisited.builder()
                .siteRootPath(siteRootPath)
                .visitedDateTime(LocalDateTime.now())
                .build();

        final String siteVisitedEventStr = ObjectMapperHolder.write(siteVisitedEvent);

        kafkaTemplate.send(SITE_VISITED_TOPIC_NAME, siteVisitedEventStr);
    }
}
