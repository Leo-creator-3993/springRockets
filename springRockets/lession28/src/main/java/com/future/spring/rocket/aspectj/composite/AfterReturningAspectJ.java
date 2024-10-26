package com.future.spring.rocket.aspectj.composite;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AfterReturningAspectJ {

    @Pointcut("execution(* com.future.spring.rocket.aspectj.service.AspectJBaseService.*(..))")
    public void pc() {
    }

    @AfterReturning(value = "pc()", returning = "retVal")
    public void around(JoinPoint joinPoint, Object retVal) {
        System.out.println("执行AfterReturning通知 ==> " + joinPoint + ", 返回值 ==> " + retVal);
    }
}
