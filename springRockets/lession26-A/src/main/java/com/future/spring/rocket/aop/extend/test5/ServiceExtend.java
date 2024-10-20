package com.future.spring.rocket.aop.extend.test5;

import org.springframework.aop.framework.AopContext;

public class ServiceExtend {
    public void m1() {
        System.out.println("调用 ==> " + "ServiceExtend.m1() 方法...");
        //this.m2();
        ((ServiceExtend) AopContext.currentProxy()).m2();
    }

    public void m2() {
        System.out.println("调用 ==> " + "ServiceExtend.m2() 方法...");
    }
}
