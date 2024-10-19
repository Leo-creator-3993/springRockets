package com.future.spring.rocket.listener;

import com.future.spring.rocket.listener.event.UserRegisterEvent;
import com.future.spring.rocket.listener.test1.impl.SendDisCountCouponListener;
import com.future.spring.rocket.listener.test1.impl.SendNoticeToAdminListener;
import com.future.spring.rocket.listener.test1.impl.SendUserEmailListener;
import com.future.spring.rocket.listener.test2.MainConfig2;
import com.future.spring.rocket.listener.test2.UserRegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

public class TestListener {

    @Test
    public void test0(){
        System.out.println("hi");
    }

    @Test
    public void test1() {
        ApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.addApplicationListener(new SendUserEmailListener());
        eventMulticaster.addApplicationListener(new SendNoticeToAdminListener());
        eventMulticaster.addApplicationListener(new SendDisCountCouponListener());
        eventMulticaster.multicastEvent(new UserRegisterEvent(this, "Mark"));
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        UserRegisterService userRegisterService = context.getBean(UserRegisterService.class);
        userRegisterService.register("John");
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigX.class);
        UserRegisterService userRegisterService = context.getBean(UserRegisterService.class);
        userRegisterService.register("Andy");
    }
}
