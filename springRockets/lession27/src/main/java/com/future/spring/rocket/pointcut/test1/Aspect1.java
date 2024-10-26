package com.future.spring.rocket.pointcut.test1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Aspect1 {

    @Pointcut(" execution(* com.future.spring.rocket.pointcut.test1.AspectBaseService1.*(..))")
    public void pc1() {

    }

    @Before(value = "pc1()")
    public void advice1(JoinPoint joinPoint) {
        System.out.println("前置通知 jointPoint ==>" + joinPoint);
    }

    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrowing1(JoinPoint joinPoint, Exception e) {
        System.out.println(joinPoint + " 发生异常, " + e.getMessage());
    }
}
