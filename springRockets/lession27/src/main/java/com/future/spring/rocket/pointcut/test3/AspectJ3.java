package com.future.spring.rocket.pointcut.test3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ3 {

    @Pointcut("this(com.future.spring.rocket.pointcut.test3.AspectJ3Impl)")
    public void pc3() {
    }

    @Before("pc3()")
    public void before3(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}