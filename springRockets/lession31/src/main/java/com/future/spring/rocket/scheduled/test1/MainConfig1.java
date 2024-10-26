package com.future.spring.rocket.scheduled.test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@ComponentScan
@EnableScheduling
public class MainConfig1 {

    //自定义线程池调度任务
    @Bean
    public ScheduledExecutorService taskScheduler() {
        int corePoolSize = 10;
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }
}
