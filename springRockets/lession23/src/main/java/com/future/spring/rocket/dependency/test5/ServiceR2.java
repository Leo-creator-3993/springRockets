package com.future.spring.rocket.dependency.test5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceR2 {

    private ServiceR1 serviceR1;

    @Autowired
    public void setServiceR1(ServiceR1 serviceR1) {
        this.serviceR1 = serviceR1;
    }

    public ServiceR1 getServiceR1() {
        return serviceR1;
    }

    public void m2() {
        serviceR1.m1();
        System.out.println("==> ServiceR2.m2()");
    }

}
