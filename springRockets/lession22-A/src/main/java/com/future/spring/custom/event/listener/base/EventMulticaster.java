package com.future.spring.custom.event.listener.base;

public interface EventMulticaster {

     void multicastEvent(AbstractEvent event);

    //增加事件监听器
     void addEventLister(EventListener<AbstractEvent> eventListener);

    //移除事件监听器
     void removeEventListener(EventListener<AbstractEvent> eventListener);
}