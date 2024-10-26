package com.future.spring.rocket.pointcut.test9;

public class AspectJ9Son extends AspectJ9Parent{

    @Override
    public void m2() {
        System.out.println("调用 ==> AspectJ9Son.m2()");
    }

    @Ann9
    public void m3() {
        System.out.println("调用 ==> AspectJ9Son.m3()");
    }
}
