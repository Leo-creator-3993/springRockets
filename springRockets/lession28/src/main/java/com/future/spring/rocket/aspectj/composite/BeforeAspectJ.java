package com.future.spring.rocket.aspectj.composite;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeforeAspectJ {

    @Pointcut("execution(* com.future.spring.rocket.aspectj.service.AspectJBaseService.*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("执行前置通知 ==> " + joinPoint);
    }
}
