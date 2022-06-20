package com.example.springdatajpasliceissue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringDataJpaSliceIssueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaSliceIssueApplication.class, args);
    }

}
