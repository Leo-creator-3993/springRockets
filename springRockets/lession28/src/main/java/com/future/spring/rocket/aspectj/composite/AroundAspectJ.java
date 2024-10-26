package com.future.spring.rocket.aspectj.composite;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AroundAspectJ {

    @Pointcut("execution(* com.future.spring.rocket.aspectj.service.AspectJBaseService.*(..))")
    public void pc() {
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("执行around通知 ==> " + proceedingJoinPoint);
        long startTime = System.nanoTime();
        Object retValue = proceedingJoinPoint.proceed();
        System.out.println("调用方法耗时 ==> " + (System.nanoTime() - startTime) + " ns." + ", 返回值 ==> " + retValue);
        return retValue;
    }
}
