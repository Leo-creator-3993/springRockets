package com.future.spring.rocket.internal;

import com.future.spring.rocket.internal.test1.MainConfig1;
import com.future.spring.rocket.internal.test2.MainConfig2;
import com.future.spring.rocket.internal.test3.MainConfig3;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SpringApplication {
    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();


        System.out.println(context.getMessage("greet", null, Locale.ROOT));
        System.out.println(context.getMessage("greet", null, Locale.CHINA));
        System.out.println(context.getMessage("greet", null, Locale.UK));

        System.out.println(context.getMessage("desc", null, Locale.ROOT));
        System.out.println(context.getMessage("desc", null, Locale.CHINA));
        System.out.println(context.getMessage("desc", null, Locale.UK));

        System.out.println(context.getMessage("desc", null, Locale.ROOT));
        System.out.println(context.getMessage("desc", new String[]{"日子","蛋糕"}, Locale.CHINA));
        System.out.println(context.getMessage("desc", new String[]{"Orange", "Water"}, Locale.UK));
    }

    @Test
    public void test2() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig2.class);
        context.refresh();

        // 要去修改classes下的message_zh_CN文件才能看到演示效果
        for(int i = 0; i < 2; i++) {
            System.out.println(context.getMessage("address", null, Locale.CHINA));
            TimeUnit.SECONDS.sleep(5);
        }
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig3.class);
        context.refresh();

        System.out.println(context.getMessage("desc", null, Locale.CHINA));
        System.out.println(context.getMessage("desc", null, Locale.UK));
    }


}
