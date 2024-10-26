package com.future.spring.rocket.pointcut.test1;

public class AspectBaseService1 {

    public void m1() {
        System.out.println(" 调用 ==> m1() 方法");
    }

    public void m2() {
        int result = 10 / 0;
        System.out.println(" 调用 ==> m2() 方法");
    }
}
