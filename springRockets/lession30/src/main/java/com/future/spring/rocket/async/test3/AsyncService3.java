package com.future.spring.rocket.async.test3;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Component
@Async
public class AsyncService3 {

    public Future<String> getGoodsInfo() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程 ==> %s 开始调用 getGoodsInfo()方法", threadName));
        return AsyncResult.forValue("LeoLeo");

    }

    public Future<String> getGoodsDesc() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程 ==> %s 开始调用 getGoodsDesc()方法", threadName));
        return AsyncResult.forValue("FooFoo");

    }

    public Future<List<String>> getGoodsComments() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程 ==> %s 开始调用 getGoodsComments()方法", threadName));
        return AsyncResult.forValue(Arrays.asList("Apple", "Pear", "Banana"));
    }

    public Future<Map<String, Integer>> getGoodsOrder() {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("线程 ==> %s 开始调用 getGoodsOrder()方法", threadName));
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("Clothes", 100);
        resultMap.put("Car", 1000);
        return AsyncResult.forValue(resultMap);
    }
}
