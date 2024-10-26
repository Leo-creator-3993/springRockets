package com.future.spring.rocket.async;

import com.future.spring.rocket.async.test1.AsyncService1;
import com.future.spring.rocket.async.test1.MainConfig1;
import com.future.spring.rocket.async.test2.AsyncService2;
import com.future.spring.rocket.async.test2.MainConfig2;
import com.future.spring.rocket.async.test3.AsyncService3;
import com.future.spring.rocket.async.test3.MainConfig3;
import com.future.spring.rocket.async.test4.AsyncService4;
import com.future.spring.rocket.async.test4.MainConfig4;
import com.future.spring.rocket.async.test5.AsyncService5;
import com.future.spring.rocket.async.test5.AsyncService5A;
import com.future.spring.rocket.async.test5.MainConfig5;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestAsyncMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        AsyncService1 asyncService1 = context.getBean(AsyncService1.class);
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("当前线程 ==> " + currentThreadName + " 开始工作...");
        asyncService1.m1();

        asyncService1.getCountDownLatch().await();
        System.out.println("当前线程 ==> " + currentThreadName + " 完成工作");
    }

    @Test
    public void test2() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        AsyncService2 asyncService2 = context.getBean(AsyncService2.class);
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("当前线程 ==> " + currentThreadName + " 开始工作...");
        asyncService2.m1(countDownLatch);
        asyncService2.m2("Climbing", countDownLatch);
        countDownLatch.await();
        System.out.println("当前线程 ==> " + currentThreadName + " 完成工作");
    }

    @Test
    public void test3() throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        AsyncService3 asyncService3 = context.getBean(AsyncService3.class);
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("当前线程 ==> " + currentThreadName + " 开始工作...");
        Future<String> goodsInfo = asyncService3.getGoodsInfo();
        Future<String> goodsDesc = asyncService3.getGoodsDesc();
        Future<List<String>> goodsComments = asyncService3.getGoodsComments();
        Future<Map<String,Integer>> goodsOrder = asyncService3.getGoodsOrder();
        System.out.println("goodsInfo ==> " + goodsInfo.get());
        System.out.println("goodsDesc ==> " + goodsDesc.get());
        System.out.println("goodsComments ==> " + goodsComments.get());
        System.out.println("goodsOrder ==> " + goodsOrder.get());

        Thread.sleep(3000);
        System.out.println("当前线程 ==> " + currentThreadName + " 完成工作");
    }

    @Test
    public void test4() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4.class);
        AsyncService4 asyncService4 = context.getBean(AsyncService4.class);
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("当前线程 ==> " + currentThreadName + " 开始工作...");
        //无返回值异常
        asyncService4.m1();
        try {
            //有返回值异常
            Future<String> result = asyncService4.m2();
            System.out.println("result ==> " + result.get());
        } catch (Exception e) {
            System.out.println("捕获到异常 ==> " + e);
        }
        Thread.sleep(3000);
        System.out.println("当前线程 ==> " + currentThreadName + " 完成工作");
    }

    @Test
    public void test5() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig5.class);
        AsyncService5 asyncService5 = context.getBean(AsyncService5.class);
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("当前线程 ==> " + currentThreadName + " 开始工作...");
        asyncService5.m1();
        asyncService5.m2();

        AsyncService5A asyncService5a = context.getBean(AsyncService5A.class);
        asyncService5a.m3();
        asyncService5a.m4();
        Thread.sleep(3000);
        System.out.println("当前线程 ==> " + currentThreadName + " 完成工作");
    }

}
