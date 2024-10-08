package com.future.spring.rocket.env;

import com.future.spring.rocket.condition.EnvCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Conditional(EnvCondition.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnvConditional {

    EnvType value() default EnvType.DEV;

    enum EnvType {
        DEV,
        TEST,
        UAT,
        PRD
    }
}
