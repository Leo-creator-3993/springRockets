package com.future.spring.rocket;

import com.future.spring.rocket.beans.RocketLaunch;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        String beansXmlPath = "classpath:beans.xml";
        String beanName = "rocketLaunch";
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(beansXmlPath);
        RocketLaunch rocketLaunch = (RocketLaunch) classPathXmlApplicationContext.getBean(beanName);
        rocketLaunch.say();
    }
}
