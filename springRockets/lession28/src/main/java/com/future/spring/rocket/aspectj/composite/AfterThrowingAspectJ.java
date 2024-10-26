package com.future.spring.rocket.aspectj.composite;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AfterThrowingAspectJ {

    @Pointcut("execution(* com.future.spring.rocket.aspectj.service.AspectJBaseService.*(..))")
    public void pc() {
    }

    @AfterThrowing(value = "pc()", throwing = "e")
    public void around(JoinPoint joinPoint, Exception e) {
        System.out.println("执行AfterThrowing通知 ==> " + joinPoint + ", 异常值 ==> " + e);
    }
}
