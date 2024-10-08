package com.future.spring.rocket.config.env;

import com.future.spring.rocket.env.EnvConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnvConditional(value = EnvConditional.EnvType.PRD)
public class PrdConfig {
    @Bean
    public String prd() {
        return "prd";
    }
}
