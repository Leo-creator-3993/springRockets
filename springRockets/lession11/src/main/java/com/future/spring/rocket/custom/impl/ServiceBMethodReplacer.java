package com.future.spring.rocket.custom.impl;


import com.future.spring.rocket.entity.PrototypeModel;
import com.future.spring.rocket.entity.PrototypeReplaceMethodModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ServiceBMethodReplacer implements MethodReplacer, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        //System.out.printf("obj:%s, method:%s, args:%s", obj, method, Arrays.toString(args));
        if(obj instanceof PrototypeModel) {
            System.out.println("1");
        } else if (obj instanceof PrototypeReplaceMethodModel){
            System.out.printf("2, method name:%s%n, args:%s%n", method.getName(),  Arrays.toString(args));
        } else {
            System.out.println("---");
        }

        return context.getBean(PrototypeModel.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
