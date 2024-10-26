package com.future.spring.rocket.autoaspectj.test3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.stereotype.Component;

@Component
public class CustomAdvisor extends DefaultPointcutAdvisor  {
    public CustomAdvisor() {
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("CustomAdvisor start");
                Object result = invocation.proceed();
                System.out.println("CustomAdvisor end");
                return result;
            }
        };
        this.setAdvice(methodInterceptor);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
