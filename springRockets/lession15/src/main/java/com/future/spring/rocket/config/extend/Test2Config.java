package com.future.spring.rocket.config.extend;

import com.future.spring.rocket.service.ConfigAService;
import com.future.spring.rocket.service.IConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Test2Config {
    @Bean
    public IConfigService myConfigService() {
        return new ConfigAService();
    }
}
