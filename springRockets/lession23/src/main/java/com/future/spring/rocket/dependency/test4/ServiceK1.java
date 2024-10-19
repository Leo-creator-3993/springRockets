package com.future.spring.rocket.dependency.test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceK1 {

    private ServiceK2 serviceK2;

    @Autowired
    public void setServiceK2(ServiceK2 serviceK2) {
        this.serviceK2 = serviceK2;
    }
}
