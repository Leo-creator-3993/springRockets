package com.future.spring.rocket.bean.definition.test4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyCustomProcessor implements SmartInstantiationAwareBeanPostProcessor {

    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)
            throws BeansException
    {
        System.out.println(beanClass);
        System.out.println("调用 determineCandidateConstructors");
        Constructor<?>[] deArr = beanClass.getDeclaredConstructors();
        if(null != deArr) {
            List<Constructor> constructorList = Arrays.stream(deArr)
                    .filter(constructor -> constructor.isAnnotationPresent(InvokeAnn.class))
                    .collect(Collectors.toList());
            Constructor[] constructors = constructorList.toArray(new Constructor[constructorList.size()]);
            return constructors.length != 0 ? constructors : null;
        } else {
            return null;
        }
    }
}
