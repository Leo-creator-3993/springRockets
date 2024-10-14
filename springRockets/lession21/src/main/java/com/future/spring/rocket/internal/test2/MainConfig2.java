package com.future.spring.rocket.internal.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MainConfig2 {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource result = new ReloadableResourceBundleMessageSource();
        result.setBasenames("message");
        result.setCacheMillis(1000);
        return result;
    }
}
