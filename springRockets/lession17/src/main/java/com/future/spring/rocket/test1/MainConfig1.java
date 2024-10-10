package com.future.spring.rocket.test1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@ComponentScan
@Configuration
public class MainConfig1 {

//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public String singleton() {
//        return "singleton";
//    }
//
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public Integer age() {
//        return 33;
//    }


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Primary
    public ScopeSingletonModel singleton() {
        return new ScopeSingletonModel();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Primary
    public ScopePrototypeModel sPrototype() {
       return new ScopePrototypeModel();
    }
}
