package com.future.spring.rocket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> beanPathList = Arrays.asList("classpath:/beans-01.xml", "classpath:/beans-02.xml", "classpath:/beans-03.xml", "classpath:/beans-04.xml");
        for(String path : beanPathList) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
            for (String beanName : context.getBeanDefinitionNames()) {
                System.out.println(beanName + ":" + context.getBean(beanName));
            }
            if(path.equals("classpath:/beans-04.xml")) {
                System.out.println(context.getBean("userModelFactoryBean"));
                System.out.println(context.getBean("userModelFactoryBean"));
            }
            System.out.println("============================================================");
        }
    }
}
