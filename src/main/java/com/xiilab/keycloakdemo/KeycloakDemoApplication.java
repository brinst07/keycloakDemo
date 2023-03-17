package com.xiilab.keycloakdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KeycloakDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakDemoApplication.class, args);
    }

}
