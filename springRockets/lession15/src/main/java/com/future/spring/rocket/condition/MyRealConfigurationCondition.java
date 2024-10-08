package com.future.spring.rocket.condition;

import com.future.spring.rocket.service.IConfigService;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyRealConfigurationCondition implements ConfigurationCondition {
    @Override
   public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
//        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
//        return !beanFactory.getBeansOfType(IConfigService.class).isEmpty();

        //获取spring容器
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //判断容器中是否存在Service类型的bean
        boolean existsService = !beanFactory.getBeansOfType(IConfigService.class).isEmpty();
        return existsService;
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.PARSE_CONFIGURATION;
    }
}
