package com.future.spring.rocket.pointcut.test7;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ7 {

    @Pointcut("@target(com.future.spring.rocket.pointcut.test6_1.Ann6X)")
    public void pc7() {
    }

    @Before("pc7()")
    public void before5(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}
