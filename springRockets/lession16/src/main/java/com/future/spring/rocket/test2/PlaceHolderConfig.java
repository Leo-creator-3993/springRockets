package com.future.spring.rocket.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceHolderConfig {

    @Bean
    public String hello() {
        return "Hello";
    }
}
