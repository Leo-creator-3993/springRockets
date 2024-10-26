package com.future.spring.rocket.pointcut.test10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class MainConfig10 {

    @Bean
    public AspectJ10 aspectJ10() {
        return new AspectJ10();
    }

    @Bean
    public BaseService baseService1() {
        return new BaseService("baseService1");
    }

    @Bean
    public BaseService baseService2() {
        return new BaseService("baseService1");
    }
}
