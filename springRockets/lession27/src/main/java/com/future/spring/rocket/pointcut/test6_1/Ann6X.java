package com.future.spring.rocket.pointcut.test6_1;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 影响子类的方法拦截
public @interface Ann6X {
}
