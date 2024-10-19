package com.future.spring.rocket.listener.test2;

import com.future.spring.rocket.listener.event.UserRegisterEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public void register(String userName) {
        System.out.println(String.format("%s ==> 用户 ==> %s 注册成功", Thread.currentThread().getName(), userName));
       applicationEventPublisher.publishEvent(new UserRegisterEvent(this, userName));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
