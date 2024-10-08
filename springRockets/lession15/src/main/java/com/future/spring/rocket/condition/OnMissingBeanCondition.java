package com.future.spring.rocket.condition;

import com.future.spring.rocket.service.IConfigService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnMissingBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        Map<String,IConfigService> serviceMap = beanFactory.getBeansOfType(IConfigService.class);
        return serviceMap.isEmpty();
    }
}
