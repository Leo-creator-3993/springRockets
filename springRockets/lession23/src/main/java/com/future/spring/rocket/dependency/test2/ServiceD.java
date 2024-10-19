package com.future.spring.rocket.dependency.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceD {

    private ServiceC serviceC;

    @Autowired
    public void setServiceC(ServiceC serviceC) {
        this.serviceC = serviceC;
    }
}
