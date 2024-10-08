package com.future.spring.rocket;

import com.future.spring.rocket.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        String beanPath = "classpath:/beans-01.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanPath);
        User user0 = (User) context.getBean("user0");
        System.out.println(user0);
    }
}
