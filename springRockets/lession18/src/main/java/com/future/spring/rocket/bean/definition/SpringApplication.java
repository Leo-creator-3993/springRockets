package com.future.spring.rocket.bean.definition;

import com.future.spring.rocket.bean.definition.test1.Car;
import com.future.spring.rocket.bean.definition.test1.ComplexModel;
import com.future.spring.rocket.bean.definition.test1.User;
import com.future.spring.rocket.bean.definition.test2.Service1;
import com.future.spring.rocket.bean.definition.test2.Service2;
import com.future.spring.rocket.bean.definition.test4.AwareBean;
import com.future.spring.rocket.bean.definition.test4.MyCustomProcessor;
import com.future.spring.rocket.bean.definition.test4.Person;
import com.future.spring.rocket.bean.definition.test4.UserModel;
import com.future.spring.rocket.bean.definition.test5.Bean1;
import com.future.spring.rocket.bean.definition.test6.MyServiceInit;
import com.future.spring.rocket.bean.definition.test7.MySmartInitializingSingleton;
import com.future.spring.rocket.bean.definition.test8.MyDestructionAwareBeanPostProcessor;
import com.future.spring.rocket.bean.definition.test8.ServiceAA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

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

    @Test
    public void test6() {
        String beanPath = "classpath:beans-01.xml";
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        int beanCount = xmlBeanDefinitionReader.loadBeanDefinitions(beanPath);
        System.out.println("注册bean的数量为:" + beanCount);

        for(String beanName : factory.getBeanDefinitionNames()) {
            System.out.println("bean的名称为:" + beanName);
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            System.out.println("bean的定义:" + beanDefinition);
            String beanClassName = beanDefinition.getClass().getName();
            System.out.println("beanClass名称:" + beanClassName);
            Object bean = factory.getBean(beanName);
            System.out.println("bean:" + bean);
        }
    }

    @Test
    public void test7(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(factory);
        reader.register(Service1.class, Service2.class);

        factory.getBeansOfType(BeanPostProcessor.class).values().forEach(factory::addBeanPostProcessor); // @1
        for(String beanName : Arrays.asList("service1", "service2")) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            String beanDefinitionName = beanDefinition.getClass().getName();
            Object bean = factory.getBean(beanName);
            System.out.println(beanName + ":");
            System.out.println(" beanDefinitionName:" + beanDefinitionName);
            System.out.println(" beanDefinition:" + beanDefinition);
            System.out.println(" bean:" + bean);
        }
    }

    @Test
    public void test8() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        GenericBeanDefinition nameBean = new GenericBeanDefinition();
        nameBean.setBeanClass(Integer.class);
        nameBean.setPrimary(true);
        nameBean.setScope("prototype");
        nameBean.setLazyInit(true);
        nameBean.getConstructorArgumentValues().addIndexedArgumentValue(0, 100);
        factory.registerBeanDefinition("age", nameBean);

        System.out.println(factory.getBeanDefinition("age"));
        System.out.println(Arrays.asList(factory.getBeanDefinitionNames()));
        System.out.println(factory.getBeanDefinitionCount());
        System.out.println(factory.isBeanNameInUse("age0"));
        System.out.println(factory.isBeanNameInUse("age"));

        factory.registerAlias("age", "ageAlias-0");
        factory.registerAlias("age", "ageAlias-1");
        System.out.println(factory.isAlias("ageAlias"));
        System.out.println(factory.isAlias("ageAlias-0"));

        System.out.println(Arrays.asList(factory.getAliases("age")));
        System.out.println(factory.getBean("age"));
    }

    @Test
    public void test9() {
        String beanPath = "classpath:beans-02.xml";
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(beanPath);

        for(String beanName : factory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            BeanDefinition mergedBeanDefinition = factory.getMergedBeanDefinition(beanName);

            System.out.println(beanName + ":");
            System.out.println("beanDefinition:" + beanDefinition);
            System.out.println("beanDefinition的属性:" + beanDefinition.getPropertyValues());
            System.out.println("mergedBeanDefinition:" + mergedBeanDefinition);
            System.out.println("mergedBeanDefinition的属性:" + mergedBeanDefinition.getPropertyValues());
            System.out.println("##############===================##################");
        }
    }

    @Test
    public void test10() {
       DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
       factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
           @Override
           public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
               System.out.println("调用-> postProcessBeforeInstantiation");
               if(beanClass == Car.class) {
                   Car car = new Car();
                   car.setName("BC");
                   return car;
               }
               return null;
           }
       });

       BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Car.class)
               .addPropertyValue("name", "BYD")
               .getBeanDefinition();

       factory.registerBeanDefinition("car", beanDefinition);
        System.out.println(factory.getBean("car"));
    }

    @Test
    public void test11() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new MyCustomProcessor());
        factory.registerBeanDefinition("name",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("路人甲Java").
                        getBeanDefinition());

        factory.registerBeanDefinition("age",
                BeanDefinitionBuilder.
                        genericBeanDefinition(Integer.class).
                        addConstructorArgValue(30).
                        getBeanDefinition());

        factory.registerBeanDefinition("person",
                BeanDefinitionBuilder.
                        genericBeanDefinition(Person.class).
                        getBeanDefinition());

        Person person = factory.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test12() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("person1", BeanDefinitionBuilder
                .genericBeanDefinition(UserModel.class)
                .addPropertyValue("name", "ZhouXc")
                .addPropertyValue("age", 66).getBeanDefinition());

        factory.registerBeanDefinition("person2", BeanDefinitionBuilder
                .genericBeanDefinition(UserModel.class)
                .addPropertyValue("name", "LiuDh")
                .addPropertyValue("age", 65).getBeanDefinition());

        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                if("person1".equals(beanName)) {
                    return false;
                } else {
                    return true;
                }
            }
        });

        for(String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void test13() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("person1", BeanDefinitionBuilder
                .genericBeanDefinition(UserModel.class)
                .getBeanDefinition());

        factory.registerBeanDefinition("person2", BeanDefinitionBuilder
                .genericBeanDefinition(UserModel.class)
                .addPropertyValue("name", "LiuDh")
                .addPropertyValue("age", 65).getBeanDefinition());

        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
                if("person1".equals(beanName)) {
                    if(pvs == null) {
                        pvs = new MutablePropertyValues();
                    }
                    if(pvs instanceof MutablePropertyValues) {
                        MutablePropertyValues mpvs = (MutablePropertyValues) pvs;
                        mpvs.add("name", "YY");
                        mpvs.add("age", 77);
                    }
                }
                return null;
            }
        });

        for(String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s -> %s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void test14() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("awareBean", BeanDefinitionBuilder.genericBeanDefinition(AwareBean.class)
                .getBeanDefinition());
        factory.getBean("awareBean");
    }

    @Test
    public void test15() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Bean1.class);
        context.refresh();
    }

    @Test
    public void test16() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MyServiceInit.class)
                .setInitMethodName("init0")
                .getBeanDefinition();
        factory.registerBeanDefinition("myServiceInit", beanDefinition);
        System.out.println(factory.getBean("myServiceInit"));
    }

    @Test
    public void test17() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //加入bean初始化后置处理器方法实现
        factory.addBeanPostProcessor(new BeanPostProcessor() {
            @Nullable
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                System.out.println("postProcessAfterInitialization：" + beanName);
                return bean;
            }
        });

        //下面注册2个String类型的bean
        factory.registerBeanDefinition("name",
                BeanDefinitionBuilder.
                        genericBeanDefinition(String.class).
                        addConstructorArgValue("公众号：【路人甲Java】").
                        getBeanDefinition());
        factory.registerBeanDefinition("personInformation",
                BeanDefinitionBuilder.genericBeanDefinition(String.class).
                        addConstructorArgValue("带领大家成为java高手！").
                        getBeanDefinition());

        System.out.println("-------输出bean信息---------");

        for (String beanName : factory.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, factory.getBean(beanName)));
        }
    }

    @Test
    public void test18() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MySmartInitializingSingleton.class);
        System.out.println("开始启动容器!");
        context.refresh();
        System.out.println("容器启动完毕!");
    }

    @Test
    public void test19() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        //添加自定义的DestructionAwareBeanPostProcessor
        factory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());

        //向容器中注入3个单例bean
        factory.registerBeanDefinition("serviceA1", BeanDefinitionBuilder.genericBeanDefinition(ServiceAA.class).getBeanDefinition());
        factory.registerBeanDefinition("serviceA2", BeanDefinitionBuilder.genericBeanDefinition(ServiceAA.class).getBeanDefinition());
        factory.registerBeanDefinition("serviceA3", BeanDefinitionBuilder.genericBeanDefinition(ServiceAA.class).getBeanDefinition());

        //触发所有单例bean初始化
        factory.preInstantiateSingletons(); //@1

        System.out.println("销毁serviceA1");
        //销毁指定的bean
        factory.destroySingleton("serviceA1");//@2

        System.out.println("触发所有单例bean的销毁");
        factory.destroySingletons();
    }


}
