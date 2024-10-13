package com.future.spring.rocket.bean.definition.test2;

import org.springframework.beans.factory.annotation.Autowired;

public class Service2 {

    @Autowired
    private Service1 service1;

    @Override
    public String toString() {
        return String.format("Hello:%s", service1);
    }
}
