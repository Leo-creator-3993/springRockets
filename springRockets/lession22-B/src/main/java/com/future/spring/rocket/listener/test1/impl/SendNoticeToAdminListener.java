package com.future.spring.rocket.listener.test1.impl;

import com.future.spring.rocket.listener.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;

public class SendNoticeToAdminListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        String userName = event.getUserName();
        System.out.println(String.format("管理员,您好! 用户 ==> %s 已注册", userName));
    }
}
