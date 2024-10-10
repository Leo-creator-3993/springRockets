package com.future.spring.rocket.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class MainConfig2 {

    @Bean
    public DependOnServiceA dServiceA() {
        System.out.println("create DependOnServiceA");
        return new DependOnServiceA();
    }

    @Bean
    @DependsOn({"dServiceC","dServiceA"})
    public DependOnServiceB dServiceB() {
        System.out.println("create DependOnServiceB");
        return new DependOnServiceB();
    }

    @Bean
    public DependOnServiceC dServiceC() {
        System.out.println("create DependOnServiceC");
        return new DependOnServiceC();
    }
}
