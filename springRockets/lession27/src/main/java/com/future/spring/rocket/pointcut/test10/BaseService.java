package com.future.spring.rocket.pointcut.test10;

public class BaseService {
    private String beanName;

    public BaseService(String beanName) {
        this.beanName = beanName;
    }

    public void m1() {
        System.out.println("调用 ==> m1()");
    }
}
