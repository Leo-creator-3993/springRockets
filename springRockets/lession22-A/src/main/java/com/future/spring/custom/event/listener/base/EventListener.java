package com.future.spring.custom.event.listener.base;

public interface EventListener<E extends AbstractEvent> {
    void onEvent(E e);
}