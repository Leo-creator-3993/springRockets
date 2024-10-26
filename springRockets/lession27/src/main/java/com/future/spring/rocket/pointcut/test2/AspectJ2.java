package com.future.spring.rocket.pointcut.test2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ2 {

    //@Pointcut(" within(com.future.spring.rocket.pointcut.test2.AJModelC1)")
    //@Pointcut(" within(com.future.spring.rocket.pointcut.test2.AJModelC2)")
    @Pointcut(" within(com.future.spring.rocket.pointcut.test2.AJModelC1+)")
    public void pc2() {
    }

    @Before(value = "pc2()")
    public void before2(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}
