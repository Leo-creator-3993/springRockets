package com.future.spring.rocket.condition;

import com.future.spring.rocket.env.EnvConditional;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnvCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        EnvConditional.EnvType currentEnv = EnvConditional.EnvType.DEV;
        EnvConditional.EnvType env = (EnvConditional.EnvType) annotatedTypeMetadata.getAllAnnotationAttributes(EnvConditional.class.getName()).get("value").get(0);
        return currentEnv.equals(env);
    }
}
