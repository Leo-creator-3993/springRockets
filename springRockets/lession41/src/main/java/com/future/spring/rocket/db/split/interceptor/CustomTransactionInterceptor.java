package com.future.spring.rocket.db.split.interceptor;

import com.future.spring.rocket.db.split.db.DbType;
import com.future.spring.rocket.db.split.db.DbTypeHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
@Order(Integer.MAX_VALUE - 2)//在DbTypeConfiguration之前执行
public class CustomTransactionInterceptor {

    @Pointcut("target(com.future.spring.rocket.db.split.service.IService)")
    public void pc() {
    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object lastArgs = getMethodLastArgs(proceedingJoinPoint);
        if (lastArgs != null) {
            if (DbType.MASTER.equals(lastArgs)) {
                DbTypeHolder.setMaster();
            } else if (DbType.SLAVE.equals(lastArgs)) {
                DbTypeHolder.setSlave();
            } else {
                System.out.println("不支持的参数类型 ==> " + lastArgs);
            }
        } else {
            System.out.println("方法最后一个参数为空");
        }
        return proceedingJoinPoint.proceed();
    }

    private Object getMethodLastArgs(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] objects = proceedingJoinPoint.getArgs();
        return Objects.nonNull(objects) ? objects[objects.length - 1] : null;
    }
}
