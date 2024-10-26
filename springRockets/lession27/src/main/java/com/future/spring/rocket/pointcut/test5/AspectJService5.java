package com.future.spring.rocket.pointcut.test5;

public class AspectJService5 {

    public <T extends Number> void m1(T cash) {
        System.out.println("调用 m1() 方法, 消费 ==> " + cash);
    }
}
