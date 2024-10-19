package com.future.spring.rocket.listener.test2;

import com.future.spring.rocket.listener.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterListener {

    @EventListener
    @Order(2)
    public void sendInviteMsg(UserRegisterEvent userRegisterEvent) {
        String userName = userRegisterEvent.getUserName();
        System.out.println(String.format("%s ==> 尊敬的用户:%s,您好! 您可邀请朋友注册获取推荐奖励!", Thread.currentThread().getName(), userName));
    }

    @EventListener
    @Order(0)
    public void sendActivitiesMsg(UserRegisterEvent userRegisterEvent) {
        String userName = userRegisterEvent.getUserName();
        System.out.println(String.format("%s ==> 尊敬的用户:%s,您好! 平台近期有优惠活动欢迎参与!", Thread.currentThread().getName(), userName));
    }
}
