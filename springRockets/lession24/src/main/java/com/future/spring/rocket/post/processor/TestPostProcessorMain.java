package com.future.spring.rocket.post.processor;

import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.post.processor.test1.BeanDefinitionRegistryPersonModel;
import com.future.spring.rocket.post.processor.test1.MainConfig1;
import com.future.spring.rocket.post.processor.test2.BeanFactoryPersonModel;
import com.future.spring.rocket.post.processor.test2.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestPostProcessorMain {

    @Test
    public void test0(){
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig1.class);
        context.refresh();
        OtherUtil.splitLinePrint();

        BeanDefinitionRegistryPersonModel markBean = (BeanDefinitionRegistryPersonModel)context.getBean("markBean");
        System.out.println(markBean);
        for(int i=0 ; i<3; i++) {
            // 观察bean的scope
            System.out.println(context.getBean("markBean"));
        }

        OtherUtil.splitLinePrint();
        System.out.println(context.getBean("caiYun"));
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig2.class);
        context.refresh();

        context.getBeansOfType(BeanFactoryPersonModel.class).forEach((beanName, bean) -> {
            System.out.printf("%s->%s%n", beanName, bean);
        });
    }
}
