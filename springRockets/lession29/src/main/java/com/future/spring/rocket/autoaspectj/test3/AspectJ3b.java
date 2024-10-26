package com.future.spring.rocket.autoaspectj.test3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AspectJ3b {

    @Pointcut("execution(* com.future.spring.rocket.autoaspectj.test3.AutoAspectJService3.*(..))")
    public void pc3() {
    }

    @Before("pc3()")
    public void before(JoinPoint joinPoint) {
        System.out.println("AspectJ3b.Before通知 ==> " + joinPoint);
    }

    @After("pc3()")
    public void after(JoinPoint joinPoint) {
        System.out.println("AspectJ3b.After通知 ==> " + joinPoint);
    }

    @Around("pc3()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AspectJ3b.Around通知 start==> " + proceedingJoinPoint);
        proceedingJoinPoint.proceed();
        System.out.println("AspectJ3b.Around通知 end==> " + proceedingJoinPoint);
    }

    @AfterReturning(value = "pc3()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, String ret) throws Throwable {
        System.out.println("AspectJ3b.AfterReturning通知 joinPoint==> " + joinPoint + ", result ==> " + ret);
    }

    @AfterThrowing(value = "pc3()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) throws Throwable {
        System.out.println("AspectJ3b.AfterThrowing通知 joinPoint==> " + joinPoint + ", exception ==> " + e);
    }
}
