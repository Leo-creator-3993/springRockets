package com.future.spring.rocket.async.test1;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class AsyncService1 {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    @Async
    public void m1() {
        String threadName = Thread.currentThread().getName();
        System.out.println("线程 ==> " + threadName + " 开始调用 m1() 方法");
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}
