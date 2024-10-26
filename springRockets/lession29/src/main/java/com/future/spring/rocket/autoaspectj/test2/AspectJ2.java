package com.future.spring.rocket.autoaspectj.test2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJ2 {

    @Pointcut("execution(* com.future.spring.rocket.autoaspectj.test2.AutoAspectJService2.*(..))")
    public void pc2() {
    }

    @Before("pc2()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before通知 ==> " + joinPoint);
    }

    @After("pc2()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After通知 ==> " + joinPoint);
    }

    @Around("pc2()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around通知 start==> " + proceedingJoinPoint);
        proceedingJoinPoint.proceed();
        System.out.println("Around通知 end==> " + proceedingJoinPoint);
    }

    @AfterReturning(value = "pc2()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, String ret) throws Throwable {
        System.out.println("AfterReturning通知 joinPoint==> " + joinPoint + ", result ==> " + ret);
    }

    @AfterThrowing(value = "pc2()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) throws Throwable {
        System.out.println("AfterThrowing通知 joinPoint==> " + joinPoint + ", exception ==> " + e);
    }
}
