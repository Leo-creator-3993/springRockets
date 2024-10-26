package com.future.spring.rocket.pointcut.test8;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ8 {

    @Pointcut("@args(Ann8)")
    public void pc8() {
    }

    @Before("pc8()")
    public void before8(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}
