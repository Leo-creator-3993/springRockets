package com.future.spring.rocket.test4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MainConfig4 {

    @Bean
    public LazyServiceA lazyServiceA() {
        System.out.println("create lazyServiceA...");
        return new LazyServiceA();
    }

    @Bean
    public LazyServiceB lazyServiceB() {
        System.out.println("create lazyServiceB...");
        return new LazyServiceB();
    }

    @Bean
    @Lazy
    public LazyServiceC lazyServiceC () {
        System.out.println("create lazyServiceC...");
        return new LazyServiceC();
    }
}