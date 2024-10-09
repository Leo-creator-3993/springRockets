package com.future.spring.rocket.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DISetterService2 {
    private DISetterService1 diSetterService1;

    @Autowired
    public void setDiSetterService1(DISetterService1 diSetterService1) {
        this.diSetterService1 = diSetterService1;
        System.out.println("Invoke setDiSetterService1");
    }

    @Override
    public String toString() {
        return String.format("diSetterService1:%s", diSetterService1);
    }
}
