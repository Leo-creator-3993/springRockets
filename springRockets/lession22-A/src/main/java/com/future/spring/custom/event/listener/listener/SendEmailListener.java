package com.future.spring.custom.event.listener.listener;

import com.future.spring.custom.event.listener.anno.MyCustomOrder;
import com.future.spring.custom.event.listener.base.EventListener;
import com.future.spring.custom.event.listener.instance.UserRegisterEvent;
import org.springframework.stereotype.Component;

@MyCustomOrder(1)
@Component
public class SendEmailListener implements EventListener<UserRegisterEvent> {
    @Override
    public void onEvent(UserRegisterEvent userRegisterEvent) {
        String userName = userRegisterEvent.getUserName();
        System.out.println(String.format("向用户 ==> %s 发送邮件", userName));
    }
}
