package com.future.spring.custom.event.listener.instance;

import com.future.spring.custom.event.listener.base.EventMulticaster;

public class UserRegisterService {

    private EventMulticaster eventMulticaster;

    public void registerUser(String userName) {
        System.out.println(String.format("注册用户 ==> %s 成功", userName));
        UserRegisterEvent userRegisterEvent = new UserRegisterEvent(this, userName);
        eventMulticaster.multicastEvent(userRegisterEvent);
    }

    public EventMulticaster getEventMulticaster() {
        return eventMulticaster;
    }

    public void setEventMulticaster(EventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }
}
