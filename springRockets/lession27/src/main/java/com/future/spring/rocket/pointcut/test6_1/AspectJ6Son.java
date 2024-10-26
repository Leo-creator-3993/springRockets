package com.future.spring.rocket.pointcut.test6_1;

public class AspectJ6Son extends AspectJ6Parent{

    @Override
    public void m2() {
        System.out.println("调用 ==> AspectJ6X.m2() 方法");
    }

    public void m3() {
        System.out.println("调用 ==> AspectJ6X.m3() 方法");
    }
}
