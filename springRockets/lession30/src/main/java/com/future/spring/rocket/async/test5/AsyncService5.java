package com.future.spring.rocket.async.test5;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async("foo")
public class AsyncService5 {

    public void m1() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程 ==> %s 开始调用m1()方法", threadName));
    }

    public Future<String> m2() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程 ==> %s 开始调用m2()方法", threadName));
        return AsyncResult.forValue("foo");
    }
}
