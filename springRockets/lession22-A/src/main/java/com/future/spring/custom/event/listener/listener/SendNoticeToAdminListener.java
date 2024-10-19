package com.future.spring.custom.event.listener.listener;

import com.future.spring.custom.event.listener.anno.MyCustomOrder;
import com.future.spring.custom.event.listener.base.EventListener;
import com.future.spring.custom.event.listener.instance.UserRegisterEvent;
import org.springframework.stereotype.Component;

@MyCustomOrder(-1)
@Component
public class SendNoticeToAdminListener implements EventListener<UserRegisterEvent> {
    @Override
    public void onEvent(UserRegisterEvent event) {
        String userName = event.getUserName();
        System.out.println(String.format("管理员,您好 用户 ==> %s 进行了注册", userName));
    }
}