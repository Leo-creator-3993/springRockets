package com.future.spring.custom.event.listener.anno;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomOrder {

    @AliasFor("priority")
    int value() default Integer.MAX_VALUE-1;

    //值越小则优先级越高
    @AliasFor("value")
    int priority() default Integer.MAX_VALUE-1;
}
