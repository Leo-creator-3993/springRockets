package com.future.spring.rocket.bean.definition.test2;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Primary
@Scope("prototype")
public class Service1 {

    @Override
    public String toString(){
        return "Foo";
    }
}
