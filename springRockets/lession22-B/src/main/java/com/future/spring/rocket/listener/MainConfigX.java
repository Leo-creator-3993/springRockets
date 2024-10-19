package com.future.spring.rocket.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.concurrent.Executor;

//实现监听器异步方式,即创建一个自定义的ApplicationEventMulticaster,并设置Excutor
@Configuration
@ComponentScan(basePackages = {"com.future.spring.rocket.listener.test2"})
public class MainConfigX {

    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
        Executor executor = applicationEventMulticasterThreadPool().getObject();
        applicationEventMulticaster.setTaskExecutor(executor);
        return applicationEventMulticaster;
    }


    @Bean
    public ThreadPoolExecutorFactoryBean applicationEventMulticasterThreadPool() {
        ThreadPoolExecutorFactoryBean result = new ThreadPoolExecutorFactoryBean();
        result.setThreadNamePrefix("applicationEventMulticasterThreadPool-");
        result.setCorePoolSize(5);
        return result;
    }

}
