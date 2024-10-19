package com.future.spring.rocket.aop.test1;

public class AopUserService {

    public void greet(String name) {
        System.out.println("Invoke greet() name ==>" + name);
    }

    public void foo() {
        System.out.println("foo foo");
    }
}
