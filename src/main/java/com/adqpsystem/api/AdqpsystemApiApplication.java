package com.adqpsystem.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditor")
public class AdqpsystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdqpsystemApiApplication.class, args);
    }

}
