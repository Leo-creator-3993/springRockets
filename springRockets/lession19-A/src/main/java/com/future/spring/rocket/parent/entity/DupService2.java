package com.future.spring.rocket.parent.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DupService2 {

    @Autowired
    private DupService1 dupService1;

    public void m2() {
        System.out.println("调用Parent-DupService2 的m2()方法");
        dupService1.m1();
    }
}
