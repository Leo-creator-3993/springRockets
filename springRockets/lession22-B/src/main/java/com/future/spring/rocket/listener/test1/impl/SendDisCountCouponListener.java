package com.future.spring.rocket.listener.test1.impl;

import com.future.spring.rocket.listener.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;

public class SendDisCountCouponListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        String userName = event.getUserName();
        System.out.println(String.format("向用户 ==> %s 发送优惠券", userName));
    }
}
