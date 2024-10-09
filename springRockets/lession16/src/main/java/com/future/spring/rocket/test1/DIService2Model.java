package com.future.spring.rocket.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DIService2Model {

    private DIService1Model diService1Model;

    public DIService2Model() {
        System.out.println("Invoke DIService2Model");
    }

    @Autowired
    public DIService2Model(DIService1Model diService1Model) {
        this.diService1Model = diService1Model;
        System.out.println("Invoke parameters DIService2Model");
    }

    @Override
    public String toString() {
        return String.format("diService1Model:%s", diService1Model);
    }

}
