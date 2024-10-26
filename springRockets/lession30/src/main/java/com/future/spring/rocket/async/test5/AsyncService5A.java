package com.future.spring.rocket.async.test5;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async("leo")
public class AsyncService5A {

    public void m3() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程 ==> %s 开始调用m3()方法", threadName));
    }

    public Future<String> m4() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程 ==> %s 开始调用m4()方法", threadName));
        return AsyncResult.forValue("leo");
    }
}
