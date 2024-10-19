package com.future.spring.custom.event.listener.instance;

import com.future.spring.custom.event.listener.base.AbstractEvent;

public class UserRegisterEvent extends AbstractEvent {
    private String userName;

    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
