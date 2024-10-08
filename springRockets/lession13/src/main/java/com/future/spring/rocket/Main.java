package com.future.spring.rocket;

import com.future.spring.rocket.configuration.ConfigModelConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigModelConfiguration.class);
        for(String beanName : context.getBeanDefinitionNames()) {
            String[] aliasName = context.getAliases(beanName);
            System.out.println(String.format("beanName:%s, aliasName:%s, bean:%s",
                    beanName,
                    Arrays.asList(aliasName),
                    context.getBean(beanName)
                    ));
        }
    }
}
