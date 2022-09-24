package com.company.password.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.company.password.rest.api"})
@EntityScan("com.company.password")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}