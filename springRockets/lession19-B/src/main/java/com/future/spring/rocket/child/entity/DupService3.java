package com.future.spring.rocket.child.entity;

import com.future.spring.rocket.parent.entity.DupService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DupService3 {

    @Autowired
    private DupService2 dupService2;

    @Autowired
    private DupService1 dupService1;

    public void m3() {
        System.out.println("调用Child-DupService3的m3()方法");
        dupService2.m2();
        dupService1.m1();
    }
}
