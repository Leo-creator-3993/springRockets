package com.future.spring.rocket.post.processor.test1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, Ordered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor 注册 ==> debug...");
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(BeanDefinitionRegistryPersonModel.class)
                .addPropertyValue("name", "Mark")
                .addPropertyValue("age", 18)
                .getBeanDefinition();
        registry.registerBeanDefinition("markBean", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 修改其scope
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("markBean");
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
