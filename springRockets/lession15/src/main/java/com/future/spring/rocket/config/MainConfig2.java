package com.future.spring.rocket.config;

import com.future.spring.rocket.condition.MyCondition1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig2 {

    @Conditional(MyCondition1.class)
    @Bean
    public String name() {
        return "JACK";
    }

    @Bean
    public String address() {
        return "SZ";
    }
}
