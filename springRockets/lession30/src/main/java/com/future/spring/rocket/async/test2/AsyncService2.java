package com.future.spring.rocket.async.test2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

@Component
@Async
public class AsyncService2 {

    public void m1(CountDownLatch countDownLatch) {
        String threadName = Thread.currentThread().getName();
        System.out.println("线程 ==> " + threadName + " 开始调用 m1() 方法");
        countDownLatch.countDown();
    }

    public CompletableFuture<Integer> m2(String msg, CountDownLatch countDownLatch) {
        String threadName = Thread.currentThread().getName();
        System.out.println("线程 ==> " + threadName + " 开始调用 m2() 方法");
        countDownLatch.countDown();
        return CompletableFuture.completedFuture(msg.length());
    }
}
