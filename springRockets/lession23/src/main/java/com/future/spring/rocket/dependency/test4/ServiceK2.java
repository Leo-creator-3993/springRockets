package com.future.spring.rocket.dependency.test4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ServiceK2 {

    private ServiceK1 serviceK1;

    @Autowired
    public void setServiceK1(ServiceK1 serviceK1) {
        this.serviceK1 = serviceK1;
    }
}
