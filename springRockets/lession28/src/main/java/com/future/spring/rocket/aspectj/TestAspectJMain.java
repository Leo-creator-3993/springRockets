package com.future.spring.rocket.aspectj;

import com.future.spring.rocket.aspectj.composite.*;
import com.future.spring.rocket.aspectj.service.AspectJBaseService;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class TestAspectJMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AspectJBaseService target = new AspectJBaseService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(BeforeAspectJ.class);

        AspectJBaseService proxy = proxyFactory.getProxy();
        proxy.greet("Leo");
        System.out.println("==> Len:" + proxy.getLen("Leo"));
    }

    @Test
    public void test2() {
        AspectJBaseService target = new AspectJBaseService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AroundAspectJ.class);

        AspectJBaseService proxy = proxyFactory.getProxy();
        proxy.greet("Leo");
        System.out.println("==> Len:" + proxy.getLen("Leo"));
    }

    @Test
    public void test3() {
        AspectJBaseService target = new AspectJBaseService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AfterAspectJ.class);

        AspectJBaseService proxy = proxyFactory.getProxy();
        proxy.greet("Leo");
        System.out.println("==> Len:" + proxy.getLen("Leo"));
    }

    @Test
    public void test4() {
        AspectJBaseService target = new AspectJBaseService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AfterReturningAspectJ.class);

        AspectJBaseService proxy = proxyFactory.getProxy();
        proxy.greet("Leo");
        System.out.println("==> Len:" + proxy.getLen("Leo"));
    }

    @Test
    public void test5() {
        AspectJBaseService target = new AspectJBaseService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AfterThrowingAspectJ.class);

        AspectJBaseService proxy = proxyFactory.getProxy();
        proxy.greet("Leo");
        System.out.println("==> Len:" + proxy.getLen("Leo"));
        proxy.login("Leo");
    }


    @Test
    public void test6() {
        AspectJBaseService target = new AspectJBaseService();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAspect(AfterThrowingAspectJ.class);

        AspectJBaseService proxy = proxyFactory.getProxy();
        proxy.greet("Mark");
        System.out.println("==> Mark:" + proxy.getLen("Mark"));
        proxy.login("Mark");
    }



}
