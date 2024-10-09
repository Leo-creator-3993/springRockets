package com.future.spring.rocket.test4;

import com.future.spring.rocket.test3.DISetterService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DIFieldService3 {

    @Autowired
    private DIFieldService1 diFieldService1;

    @Autowired
    private DIFieldService2 diFieldService2;

    @Override
    public String toString() {
        return String.format("diFieldService1:%s, diFieldService2:%s", diFieldService1, diFieldService2);
    }
}
