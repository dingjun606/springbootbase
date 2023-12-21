package com.iai.project.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.iai.project"})
@EnableMongoRepositories(basePackages = {"com.iai.project.common.mongo", "com.iai.project.common.service", "com.iai.project.common.responsitory"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
