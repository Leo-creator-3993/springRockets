package com.future.spring.rocket.listener.test1.impl;

import com.future.spring.rocket.listener.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;

public class SendUserEmailListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println(String.format("向用户 ==> %s 发送邮件", event.getUserName()));
    }
}
