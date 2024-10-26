package com.future.spring.rocket.pointcut.test6;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ6 {

    @Pointcut("@within(Ann6)")
    public void pc6() {
    }

    @Before("pc6()")
    public void before5(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}
