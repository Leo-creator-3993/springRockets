package com.future.spring.rocket.scheduled.test1;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledService1 {

    @Scheduled(cron = "*/1 * * * * ?")
    public void task1() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程:%s 开始执行 ==> task1 %s", threadName, System.currentTimeMillis()));
    }

    @Scheduled(fixedRate = 1000)
    public void task2() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程:%s 开始执行 ==> task2 %s", threadName, System.currentTimeMillis()));
    }

    @Scheduled(fixedRate = 1000)
    public void task3() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程:%s 开始执行 ==> task3 %s", threadName, System.currentTimeMillis()));
    }
}
