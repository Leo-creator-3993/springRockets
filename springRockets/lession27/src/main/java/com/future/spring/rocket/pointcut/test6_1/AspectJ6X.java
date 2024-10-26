package com.future.spring.rocket.pointcut.test6_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ6X {

    @Pointcut("@within(Ann6X)")
    public void pc6x() {
    }

    @Before("pc6x()")
    public void before5(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}
