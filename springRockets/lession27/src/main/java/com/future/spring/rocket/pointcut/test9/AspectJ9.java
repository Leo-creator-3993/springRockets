package com.future.spring.rocket.pointcut.test9;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ9 {

    @Pointcut("@annotation(com.future.spring.rocket.pointcut.test9.Ann9)")
    public void pc9() {
    }

    @Before("pc9()")
    public void before8(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}
