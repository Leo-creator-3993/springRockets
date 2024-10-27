package com.future.spring.rocket.spel.test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class MainConfig {

    @Bean
    public String name() {
        return "Leo";
    }

    @Bean
    public String msg() {
        return "Foo";
    }
}
