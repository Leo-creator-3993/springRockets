package com.future.spring.rocket.dependency.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ServiceM1 {

    private ServiceM2 serviceM2;

    @Autowired
    public void setServiceM2(ServiceM2 serviceM2) {
        this.serviceM2 = serviceM2;
    }
}
