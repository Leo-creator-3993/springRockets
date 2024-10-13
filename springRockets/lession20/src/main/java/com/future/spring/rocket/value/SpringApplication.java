package com.future.spring.rocket.value;

import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.value.test1.MainConfig1;
import com.future.spring.rocket.value.test1.ValueModel;
import com.future.spring.rocket.value.test2.CustomSourceModel;
import com.future.spring.rocket.value.test2.DbSimulateUtil;
import com.future.spring.rocket.value.test2.MainConfig2;
import com.future.spring.rocket.value.test3.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class SpringApplication {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        ValueModel valueModel = context.getBean(ValueModel.class);
        System.out.println(valueModel);
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        Map<String, Object> dbProperties = DbSimulateUtil.getDbProperties();
        MapPropertySource mapPropertySource = new MapPropertySource("mail", dbProperties);
        context.getEnvironment().getPropertySources().addFirst(mapPropertySource);
        context.register(MainConfig2.class);
        context.refresh();

        CustomSourceModel customSourceModel = context.getBean(CustomSourceModel.class);
        System.out.println(customSourceModel);
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getBeanFactory().registerScope(MyRefreshScope.REFRESH_SCOPE, MyRefreshScope.getINSTANCE());
        context.register(MainConfig3.class);
        SimulateUpdateUtil.refreshDbProperties(context);
        context.refresh();

        AutoRefreshService autoRefreshService = context.getBean(AutoRefreshService.class);
        System.out.println(autoRefreshService.getAutoRefreshModel().getClass());//观察到CGLib动态代理增强
        for(int i=0; i < 3; i++) {
            System.out.println(context.getBean(AutoRefreshService.class));
        }

        OtherUtil.splitLinePrint();
        for(int i=0; i < 3; i++) {
            //模拟动态更新数据库配置
            SimulateUpdateUtil.refreshDbProperties(context);
            System.out.println(context.getBean(AutoRefreshService.class));
        }

    }
}
