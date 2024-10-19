package com.future.spring.rocket.post.processor.test2;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //异常演示:不要在此方法中去获取其他bean,将影响personModel1 Bean的name属性注入
        beanFactory.getBean("personModel1");

        //重设name属性
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("personModel2");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.add("name", "竹杖芒鞋轻胜马");
    }
}
