package com.future.spring.rocket.tx.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class Aspect1 {

    @Pointcut("execution(* com.future.spring.rocket.tx.order.UserService.*(..))")
    public void pc1() {
    }

    @Around("pc1()")
    public void tsBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before start...");
        joinPoint.proceed();
        System.out.println("before end...");
    }
}
