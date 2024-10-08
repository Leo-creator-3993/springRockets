package com.future.spring.rocket.config;

import com.future.spring.rocket.condition.OnMissingBeanCondition;
import com.future.spring.rocket.service.ConfigAService;
import com.future.spring.rocket.service.ConfigBService;
import com.future.spring.rocket.service.IConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig3 {

    @Bean
    @Conditional(OnMissingBeanCondition.class)
    public IConfigService configBService() {
        return new ConfigBService();
    }

    @Bean
    @Conditional(OnMissingBeanCondition.class)
    public IConfigService configAService() {
        return new ConfigAService();
    }
}
