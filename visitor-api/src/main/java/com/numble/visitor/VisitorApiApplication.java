package com.numble.visitor;

import com.numble.visitor.domain.VisitorDomainApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackageClasses = {VisitorApiApplication.class, VisitorDomainApplication.class})
public class VisitorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisitorApiApplication.class, args);
    }

}
