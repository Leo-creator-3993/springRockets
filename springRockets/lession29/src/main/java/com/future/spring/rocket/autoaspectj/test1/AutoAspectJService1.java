package com.future.spring.rocket.autoaspectj.test1;

import org.springframework.stereotype.Component;

@Component
public class AutoAspectJService1 {

    public void m1() {
        System.out.println("调用 ==> m1() 方法");
    }
}
