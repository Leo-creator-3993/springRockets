package com.future.spring.rocket.pointcut.test9;

public class AspectJ9Parent {

    @Ann9
    public void m1() {
        System.out.println("调用 ==> AspectJ9Parent.m1()");
    }

    @Ann9
    public void m2() {
        System.out.println("调用 ==> AspectJ9Parent.m2()");
    }


}
