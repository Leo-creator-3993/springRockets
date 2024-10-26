package com.future.spring.rocket.scheduled;

import com.future.spring.rocket.scheduled.test1.MainConfig1;
import com.future.spring.rocket.scheduled.test1.ScheduledService1;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestScheduledMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        ScheduledService1 scheduledService1 = context.getBean(ScheduledService1.class);

        Thread.sleep(10000);
    }
}
