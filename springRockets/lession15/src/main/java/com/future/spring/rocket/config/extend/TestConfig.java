package com.future.spring.rocket.config.extend;

import com.future.spring.rocket.condition.MyRealConfigurationCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    //@Conditional(MyConfigurationCondition.class)
    @Conditional(MyRealConfigurationCondition.class)
    public String testConfig() {
        return "testConfig";
    }

}
