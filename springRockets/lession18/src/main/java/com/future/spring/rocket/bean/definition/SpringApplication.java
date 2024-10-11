package com.future.spring.rocket.bean.definition;

import com.future.spring.rocket.bean.definition.test1.Car;
import com.future.spring.rocket.bean.definition.test1.ComplexModel;
import com.future.spring.rocket.bean.definition.test1.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;

import java.util.Arrays;

public class SpringApplication {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        String beanName = Car.class.getName();
        System.out.println("beanName:" + beanName);
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(beanName);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);
    }

    @Test
    public void test2() {
        String beanName = Car.class.getName();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(beanName);
        beanDefinitionBuilder.addPropertyValue("name", "BYD");

        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("car", beanDefinition);

        Car car = beanFactory.getBean("car", Car.class);
        System.out.println(car);
    }

    @Test
    public void test3() {

        BeanDefinition carBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName()).addPropertyValue("name", "S7").getBeanDefinition();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(User.class.getName());
        beanDefinitionBuilder.addPropertyValue("name", "CC");
        beanDefinitionBuilder.addPropertyReference("car", "car");
        BeanDefinition userBeanDefinition = beanDefinitionBuilder.getBeanDefinition();

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("car", carBeanDefinition);
        beanFactory.registerBeanDefinition("user", userBeanDefinition);

        Car car = beanFactory.getBean("car", Car.class);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(car);
        System.out.println(user);
    }

    @Test
    public void test4() {
        BeanDefinition car1BeanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(Car.class)
                .addPropertyValue("name", "LX")
                .getBeanDefinition();

        BeanDefinition car2BeanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(Car.class)
                .setParentName("car1")
                .getBeanDefinition();

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("car1", car1BeanDefinition);
        beanFactory.registerBeanDefinition("car2", car2BeanDefinition);

        System.out.println("car1:" + beanFactory.getBean("car1"));
        System.out.println("car2:" + beanFactory.getBean("car2"));
    }

    @Test
    public void test5() {
        BeanDefinition car1BeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .addPropertyValue("name", "AIT")
                .getBeanDefinition();
        BeanDefinition car2BeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
                .addPropertyValue("name", "DF")
                .getBeanDefinition();

        ManagedList<String> stringManagedList = new ManagedList<>();
        stringManagedList.addAll(Arrays.asList("day", "happy"));

        ManagedList<RuntimeBeanReference> carManagedList = new ManagedList<>();
        carManagedList.add(new RuntimeBeanReference("car1BeanDefinition"));
        carManagedList.add(new RuntimeBeanReference("car2BeanDefinition"));

        ManagedSet<String> stringManagedSet = new ManagedSet<>();
        stringManagedSet.addAll(Arrays.asList("11", "22"));

        ManagedSet<RuntimeBeanReference> carManagedSet = new ManagedSet<>();
        carManagedSet.add(new RuntimeBeanReference("car1BeanDefinition"));
        carManagedSet.add(new RuntimeBeanReference("car2BeanDefinition"));

        ManagedMap<String, String> stringManagedMap = new ManagedMap<>();
        stringManagedMap.put("aa", "yesterday");
        stringManagedMap.put("bb", "today");
        stringManagedMap.put("cc", "tomorrow");

        ManagedMap<String, RuntimeBeanReference>  carManagedMap = new ManagedMap<>();
        carManagedMap.put("uu", new RuntimeBeanReference("car1BeanDefinition"));
        carManagedMap.put("mm", new RuntimeBeanReference("car2BeanDefinition"));

        GenericBeanDefinition complexModelBeanDefinition = new GenericBeanDefinition();
        complexModelBeanDefinition.setBeanClass(ComplexModel.class);
        complexModelBeanDefinition.getPropertyValues()
                .add("name", "creator")
                .add("car", new RuntimeBeanReference("car1BeanDefinition"))
                .add("stringList", stringManagedList)
                .add("carList", carManagedList)
                .add("stringSet", stringManagedSet)
                .add("carSet", carManagedSet)
                .add("stringMap", stringManagedMap)
                .add("carMap", carManagedMap);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("car1BeanDefinition", car1BeanDefinition);
        beanFactory.registerBeanDefinition("car2BeanDefinition", car2BeanDefinition);
        beanFactory.registerBeanDefinition("complexModel", complexModelBeanDefinition);

        for(String beanName: beanFactory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, beanFactory.getBean(beanName)));
        }
    }

}
