package com.future.spring.rocket.configuration;

import com.future.spring.rocket.entity.ConfigModelA;
import com.future.spring.rocket.entity.ConfigModelB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// 加了Configuration注解则bean的生命周期受spring管理，对bean添加的注解修饰才能生效，
// 否则没加则不受spring管理，添加对bean的注解是无法生效的
@Configuration
public class ConfigModelConfiguration {

    @Bean
    @Scope("singleton")
    public ConfigModelA configModelA() {
        System.out.println("调用configModelA");
        return new ConfigModelA();
    }

    @Bean
    public ConfigModelB configModelB() {
        System.out.println("调用configModelB");
        ConfigModelA configModelA = configModelA();
        return new ConfigModelB(configModelA);
    }
}
