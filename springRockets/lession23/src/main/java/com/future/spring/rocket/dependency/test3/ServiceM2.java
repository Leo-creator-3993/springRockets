package com.future.spring.rocket.dependency.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ServiceM2 {

    private ServiceM1 serviceM1;

    @Autowired
    public void setServiceM1(ServiceM1 serviceM1) {
        this.serviceM1 = serviceM1;
    }
}
