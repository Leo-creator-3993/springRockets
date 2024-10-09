package com.future.spring.rocket.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DIMethodService2 {
    private DIMethodService1 diMethodService1;
    private String placeHolder;

    @Autowired
    public void injectInstance(DIMethodService1 diMethodService1, @Autowired(required = false) String placeHolder) {
        this.diMethodService1 = diMethodService1;
        this.placeHolder = placeHolder;
        System.out.println("调用injectInstance");
    }

    @Override
    public String toString() {
        return String.format("diMethodService1:%s, placeHolder:%s", diMethodService1, placeHolder);
    }
}
