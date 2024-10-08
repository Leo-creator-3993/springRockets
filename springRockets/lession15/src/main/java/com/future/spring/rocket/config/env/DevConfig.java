package com.future.spring.rocket.config.env;

import com.future.spring.rocket.env.EnvConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnvConditional(value = EnvConditional.EnvType.DEV)
public class DevConfig {
    @Bean
    public String dev() {
        return "dev";
    }
}
