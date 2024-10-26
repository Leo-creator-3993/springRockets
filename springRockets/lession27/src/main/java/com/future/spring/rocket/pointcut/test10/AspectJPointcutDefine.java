package com.future.spring.rocket.pointcut.test10;

import org.aspectj.lang.annotation.Pointcut;

public class AspectJPointcutDefine {

    @Pointcut("bean(baseService1)")
    public void pc1() {
    }

    @Pointcut("bean(baseService2)")
    public void pc2() {

    }
}
