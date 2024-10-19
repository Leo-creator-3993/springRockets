package com.future.spring.custom.event.listener.config;

import com.future.spring.custom.event.listener.base.EventListener;
import com.future.spring.custom.event.listener.base.EventMulticaster;
import com.future.spring.custom.event.listener.base.SimpleEventMulticaster;
import com.future.spring.custom.event.listener.instance.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.future.spring.custom.event.listener"})
public class MainConfig {

    @Bean
    @Autowired(required = false)
    public EventMulticaster eventMulticaster(List<EventListener> eventListenerList) {
        EventMulticaster eventMulticaster = new SimpleEventMulticaster();
        if(null != eventListenerList) {
            eventListenerList.forEach(eventMulticaster::addEventLister);
        }
        return eventMulticaster;
    }

    @Bean
    public UserRegisterService userRegisterService(EventMulticaster eventMulticaster) {
        UserRegisterService userRegisterService = new UserRegisterService();
        userRegisterService.setEventMulticaster(eventMulticaster);
        return userRegisterService;
    }
}
