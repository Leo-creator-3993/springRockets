package com.future.spring.rocket.pointcut.test4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ4 {

    @Pointcut("target(com.future.spring.rocket.pointcut.test3.AspectJ3Impl)")
    public void pc4() {
    }

    @Before("pc4()")
    public void before4(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}