package com.future.spring.rocket.async.test3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@ComponentScan
@EnableAsync
public class MainConfig3 {

    @Bean
    public AsyncConfigurer asyncConfigurer() {
        return new AsyncConfigurer() {
            @Override
            public Executor getAsyncExecutor() {
                ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
                executor.setCorePoolSize(5);
                executor.setMaxPoolSize(10);
                executor.setQueueCapacity(100);
                executor.setThreadNamePrefix("-Foo-Thread-");
                executor.initialize();
                return executor;
            }
        };
    }
}
