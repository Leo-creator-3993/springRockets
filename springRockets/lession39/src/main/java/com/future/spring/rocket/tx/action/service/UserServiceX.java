package com.future.spring.rocket.tx.action.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceX {

    @Autowired
    private UserService userService;

    @Autowired
    private MsgSender msgSender;

    @Transactional
    public void nested() {
        this.msgSender.send("消息1", 2, "1");
        this.userService.registerRequiresNew(9527, "LeoLeo");
        this.userService.registerFail(4242, "FooFoo");
    }
}
