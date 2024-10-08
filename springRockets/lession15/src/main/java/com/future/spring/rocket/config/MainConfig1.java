package com.future.spring.rocket.config;

import com.future.spring.rocket.condition.MyCondition1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional(MyCondition1.class)
@Configuration
public class MainConfig1 {

    @Bean
    public String name() {
        return "Hello";
    }
}
