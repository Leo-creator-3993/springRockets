package com.future.spring.rocket.child;

import com.future.spring.rocket.child.entity.DupService3;
import com.future.spring.rocket.child.entity.MainConfig2;
import com.future.spring.rocket.parent.entity.DupMainConfig1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class SpringApplication {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void testBeanNameConflictException() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class, DupMainConfig1.class);
        DupService3 dupService3 = context.getBean(DupService3.class);
        dupService3.m3();
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
        parentContext.register(DupMainConfig1.class);
        parentContext.refresh();
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
        childContext.register(MainConfig2.class);
        childContext.setParent(parentContext);
        childContext.refresh();

        DupService3 dupService3 = childContext.getBean(DupService3.class);
        dupService3.m3();
    }

    @Test
    public void test2() {
        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        parentBeanFactory.registerBeanDefinition("userName", BeanDefinitionBuilder.genericBeanDefinition(String.class)
                        .addConstructorArgValue("TT")
                .getBeanDefinition());

        DefaultListableBeanFactory childBeanFactory = new DefaultListableBeanFactory();
        childBeanFactory.setParentBeanFactory(parentBeanFactory);
        childBeanFactory.registerBeanDefinition("address", BeanDefinitionBuilder.genericBeanDefinition(String.class)
                        .addConstructorArgValue("SZ")
                .getBeanDefinition());

        // 子容器可以访问父容器
        System.out.println(childBeanFactory.getBean("userName"));

        // 子容器无法按类型查找递归查找
        System.out.println(Arrays.asList(childBeanFactory.getBeanNamesForType(String.class)));

        // 工具类支持层次查找bean名称
        String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(childBeanFactory, String.class);
        System.out.println(Arrays.asList(beanNames));

        // 工具类层次查找beanMap
        Map<String, String> beansOfTypeIncludingAncestors = BeanFactoryUtils.beansOfTypeIncludingAncestors(childBeanFactory, String.class);
        System.out.println(Arrays.asList(beansOfTypeIncludingAncestors));
    }

}
