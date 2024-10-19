package com.future.spring.rocket.dependency.test5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceR1 {

    private ServiceR2 serviceR2;

    @Autowired
    public void setServiceR2(ServiceR2 serviceR2) {
        this.serviceR2 = serviceR2;
    }

    public void m1() {
        System.out.println("==> ServiceR1.m1()");
    }
}
