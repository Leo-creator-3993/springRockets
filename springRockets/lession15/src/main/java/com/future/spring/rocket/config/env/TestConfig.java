package com.future.spring.rocket.config.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnvConditional(value = EnvConditional.EnvType.TEST)
public class TestConfig {
    @Bean
    public String test() {
        return "test";
    }
}
