package com.future.spring.rocket.internal.test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MainConfig1 {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource result = new ResourceBundleMessageSource();
        result.setBasename("message");
        return result;
    }
}
