package com.future.spring.rocket.test.module;

import com.future.spring.rocket.test.MainConfig;
import com.future.spring.rocket.test.SpringTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MainConfig.class)
public class MainConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringTestService springTestService;

    @Test
    public void testName() {
        System.out.println("==> Before 【testName】...");
        String name = springTestService.name();
        System.out.println(name);
        assertEquals("foo", name);
        System.out.println("==> End 【testName】...");
    }

    @Test
    public void testAge() {
        System.out.println("==> Before 【testAge】...");
        int age = springTestService.age();
        System.out.println(age);
        assertEquals(18, age);
        System.out.println("==> End 【testAge】...");
    }

    @Test
    public void test1() {
        System.out.println("==> Before 【test1】...");
        SpringTestService springTestService1 = applicationContext.getBean(SpringTestService.class);
        System.out.println("==>" + springTestService1.name());
        System.out.println("==>" + springTestService1.age());
        System.out.println("==> End 【test1】...");
    }
}
