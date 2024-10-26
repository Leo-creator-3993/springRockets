package com.future.spring.rocket.async.test4;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;

@ComponentScan
@EnableAsync
public class MainConfig4 {

    @Bean
    public AsyncConfigurer asyncConfigurer() {
        return new AsyncConfigurer() {
            @Override
            public Executor getAsyncExecutor() {
                ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
                executor.setCorePoolSize(5);
                executor.setMaxPoolSize(10);
                executor.setQueueCapacity(100);
                executor.setThreadNamePrefix("Leo-Thread-");
                executor.initialize();
                return executor;
            }

            @Override
            public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
                return new AsyncUncaughtExceptionHandler() {
                    @Override
                    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
                        System.out.println(String.format("捕获到 method ==> %s objects ==> %s e ==> %s", method, Arrays.asList(objects), throwable));
                    }
                };
            }
        };
    }
}
