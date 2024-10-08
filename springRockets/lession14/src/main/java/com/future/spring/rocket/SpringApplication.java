package com.future.spring.rocket;

import com.future.spring.rocket.custom.OnlyOneFilter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@ComponentScan(basePackages = {"com.future.spring.rocket.controller", "com.future.spring.rocket.model"})
//@ComponentScan(basePackages = {"com.future.spring.rocket"},
//               includeFilters = {@ComponentScan.Filter(value = {ScanMark.class})},
//               useDefaultFilters = false)
//@ComponentScan(basePackages = {"com.future.spring.rocket"})
@ComponentScan(basePackages = {"com.future.spring.rocket"},
        includeFilters = {@ComponentScan.Filter( type = FilterType.CUSTOM, value = OnlyOneFilter.class)},
        useDefaultFilters = false)
//@ComponentScan(basePackageClasses = {ComponentScanUserController.class, ComponentScanUserService.class})
public class SpringApplication {

    @org.junit.Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);
        for(String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, context.getBean(beanName)));
        }
    }
}
