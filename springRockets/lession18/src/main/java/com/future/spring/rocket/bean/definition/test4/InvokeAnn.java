package com.future.spring.rocket.bean.definition.test4;

import java.lang.annotation.*;

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InvokeAnn {
}
