package com.future.spring.custom.event.listener.base;

import com.future.spring.custom.event.listener.anno.MyCustomOrder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleEventMulticaster implements EventMulticaster {

    //<事件类型,监听器列表>
    private final Map<Class<?>, List<EventListener<AbstractEvent>>> eventListenerMap = new ConcurrentHashMap<>();

    //取出监听器并调用onEvent
    @Override
    public  void multicastEvent(AbstractEvent event) {
        List<EventListener<AbstractEvent>> eventListenerList = eventListenerMap.get(event.getClass());
        if (eventListenerList != null) {
            List<EventListener<AbstractEvent>> sortedEventListenerList = sortEventListener(eventListenerList);
            for (EventListener<AbstractEvent> eventListener : sortedEventListenerList) {
                eventListener.onEvent(event);
            }
        }
    }

    @Override
    public void addEventLister(EventListener<AbstractEvent> eventListener) {
        Class<?> eventType = getEventType(eventListener);
        List<EventListener<AbstractEvent>> eventListenerList = eventListenerMap.computeIfAbsent(eventType, k -> new ArrayList<>());
        eventListenerList.add(eventListener);
    }

    @Override
    public  void removeEventListener(EventListener<AbstractEvent> eventListener) {
        Class<?> eventType = getEventType(eventListener);
        List<EventListener<AbstractEvent>> eventListenerList = eventListenerMap.get(eventType);
        if(null != eventListenerList) {
            eventListenerList.remove(eventListener);
        }
    }

    //获取事件类型
    private <T extends AbstractEvent> Class<?> getEventType(EventListener<T> listener) {
        Type genericType = listener.getClass().getGenericInterfaces()[0];
        if(genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            Type eventType = parameterizedType.getActualTypeArguments()[0];
            return (Class<?>) eventType;
        }
        return null;
    }

    //根据@MyCustomOrder注解排序
    private  List<EventListener<AbstractEvent>> sortEventListener(List<EventListener<AbstractEvent>> eventListenerList) {
        eventListenerList.sort(Comparator.comparingInt(listener -> {
            // 通过反射获取 @MyCustomOrder 注解
            MyCustomOrder myCustomOrder = listener.getClass().getAnnotation(MyCustomOrder.class);
            // 如果注解存在，返回注解的值；如果不存在，默认返回一个较大的值，如 Integer.MAX_VALUE
            return myCustomOrder != null ? myCustomOrder.value() : Integer.MAX_VALUE;
        }));
        return  eventListenerList;
    }
}
