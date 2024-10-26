package com.future.spring.rocket.pointcut.test10;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJ10 {

    @Pointcut("com.future.spring.rocket.pointcut.test10.AspectJPointcutDefine.pc1() || com.future.spring.rocket.pointcut.test10.AspectJPointcutDefine.pc2()")
    public void pc10() {
    }

    @Before("pc10()")
    public void before8(JoinPoint joinPoint) {
        System.out.println("前置通知, joinPoint ==> " + joinPoint);
    }
}
