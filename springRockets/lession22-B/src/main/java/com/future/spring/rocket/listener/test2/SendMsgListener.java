package com.future.spring.rocket.listener.test2;

import com.future.spring.rocket.listener.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-1)
public class SendMsgListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        String userName = event.getUserName();
        System.out.println(String.format("%s ==> 尊敬的用户:%s,您好! 您已成功完成注册流程!", Thread.currentThread().getName(), userName));
    }
}
