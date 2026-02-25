package com.thaloz.job019;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Job019Application {

    public static void main(String[] args) {
        SpringApplication.run(Job019Application.class, args);
    }

}
