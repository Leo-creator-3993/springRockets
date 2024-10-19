package com.future.spring.rocket.post.processor.test2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class MainConfig2 {

    @Bean
    public BeanFactoryPersonModel personModel1(){
        return new BeanFactoryPersonModel();
    }

    @Bean
    public BeanFactoryPersonModel personModel2(){
        return new BeanFactoryPersonModel();
    }


    @Bean
    public String name() {
        return "一蓑烟雨任平生";
    }
}
