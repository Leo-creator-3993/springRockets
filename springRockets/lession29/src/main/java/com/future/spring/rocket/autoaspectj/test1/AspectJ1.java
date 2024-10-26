package com.future.spring.rocket.autoaspectj.test1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJ1 {

    @Pointcut("execution(* com.future.spring.rocket.autoaspectj.test1.AutoAspectJService1.*(..))")
    public void pc1() {
    }

    @Before("pc1()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知 ==> " + joinPoint);
    }
}
