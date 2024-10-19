package com.future.spring.rocket.post.processor.test1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class StringBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, Ordered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("StringBeanDefinitionRegistryPostProcessor 注册 ==> debug...");
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(String.class)
                .addConstructorArgValue("朝辞白帝彩云间, 千里江陵一日还。 \n两岸猿声啼不住, 轻舟已过万重山。")
                .getBeanDefinition();
        registry.registerBeanDefinition("caiYun", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
