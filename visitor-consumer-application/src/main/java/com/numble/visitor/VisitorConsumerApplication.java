package com.numble.visitor;

import com.numble.visitor.domain.VisitorDomainApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication(scanBasePackageClasses = {VisitorConsumerApplication.class, VisitorDomainApplication.class})
public class VisitorConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisitorConsumerApplication.class, args);
    }

}
