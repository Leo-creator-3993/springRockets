package com.future.spring.rocket.aspectj.composite;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AfterAspectJ {

    @Pointcut("execution(* com.future.spring.rocket.aspectj.service.AspectJBaseService.*(..))")
    public void pc() {
    }

    @After("pc()")
    public void around(JoinPoint joinPoint) {
        System.out.println("执行After通知 ==> " + joinPoint);
    }
}
