package com.future.spring.rocket.pointcut.test5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ5 {

    @Pointcut("args(Integer)")
    public void pc5() {
    }

    @Before("pc5()")
    public void before5(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}
