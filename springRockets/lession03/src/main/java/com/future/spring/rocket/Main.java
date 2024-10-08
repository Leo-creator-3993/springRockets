package com.future.spring.rocket;


import com.future.spring.rocket.custom.ThreadScope;
import com.future.spring.rocket.entity.BeanItem;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String beanPath = "classpath:/beans-01.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanPath);
        //单例
        for(int i = 0; i < 3; i++) {
            BeanItem beanItem = (BeanItem) context.getBean("beanItem");
            System.out.printf("beanItem:%s%n", beanItem);
        }

        System.out.println("=================================================================");
        //多实例
        for(int i = 0; i < 3; i++) {
            BeanItem beanItem = (BeanItem) context.getBean("beanItemX");
            System.out.printf("beanItemX:%s%n", beanItem);
        }
        System.out.println("=================================================================");
        //自定义
        ClassPathXmlApplicationContext contextX = new ClassPathXmlApplicationContext();
        contextX.setConfigLocation(beanPath);
        contextX.refresh();
        contextX.getBeanFactory().registerScope("thread", new ThreadScope());
        for(int i = 0; i < 2; i++) {
            new Thread(()-> {
                System.out.println(String.format("thread:%s, get bean:%s", Thread.currentThread(), contextX.getBean("beanCustom")));
                System.out.println(String.format("thread:%s, get bean:%s", Thread.currentThread(), contextX.getBean("beanCustom")));
            }).start();
            TimeUnit.SECONDS.sleep(1);
        }

        BeanItem beanItemX = (BeanItem) contextX.getBean("beanItem");
        System.out.println(String.format("getBean:%s", beanItemX));

    }

}
