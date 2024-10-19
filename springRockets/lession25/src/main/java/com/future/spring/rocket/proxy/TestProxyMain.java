package com.future.spring.rocket.proxy;

import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.proxy.cglibtest.MethodCostTimeInterceptor;
import com.future.spring.rocket.proxy.cglibtest.MethodCostTimeInterceptor2;
import com.future.spring.rocket.proxy.cglibtest.ServiceCgLibInstance;
import com.future.spring.rocket.proxy.dispatchtest.DispatchModel;
import com.future.spring.rocket.proxy.jdktest.IServiceJ1;
import com.future.spring.rocket.proxy.jdktest.IServiceJ2;
import com.future.spring.rocket.proxy.jdktest.MethodCostTimeInvokeHandler;
import com.future.spring.rocket.proxy.jdktest.ServiceJImpl;
import com.future.spring.rocket.proxy.lazyloadtest.MyBolgModel;
import com.future.spring.rocket.proxy.naming.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.DefaultNamingPolicy;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxyMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void testJdkProxy() {
        ServiceJImpl serviceJ = new ServiceJImpl();
        Class<? extends ServiceJImpl> target = serviceJ.getClass();
        InvocationHandler handler = new MethodCostTimeInvokeHandler(serviceJ);
        Object proxy = Proxy.newProxyInstance(target.getClassLoader(), new Class[]{IServiceJ1.class, IServiceJ2.class}, handler);
        System.out.println(proxy instanceof ServiceJImpl);
        System.out.println(proxy instanceof IServiceJ1);
        System.out.println(proxy instanceof IServiceJ2);
        System.out.println("serviceJ:" + serviceJ.getClass() + ", proxy:" + proxy.getClass());
        OtherUtil.splitLinePrint();
        assert proxy instanceof IServiceJ1;
        IServiceJ1 j1 = (IServiceJ1) proxy;
        j1.j1();
        OtherUtil.splitLinePrint();
        assert proxy instanceof IServiceJ2;
        IServiceJ2 j2 = (IServiceJ2) proxy;
        j2.j2();
    }

    @Test
    public void test1X() {
        //jdk动态代理只能对子类中重写接口的方法进行增强
        ServiceCgLibInstance cgLibInstance = new ServiceCgLibInstance();
        Class<?> target = cgLibInstance.getClass();
        InvocationHandler handler = new MethodCostTimeInvokeHandler(cgLibInstance);
        Object proxy = Proxy.newProxyInstance(target.getClassLoader(), new Class[]{}, handler);
        System.out.println("cgLibInstance:" + cgLibInstance.getClass() + ", proxy:" + proxy.getClass());
    }

    @Test
    public void test1() {
        ServiceCgLibInstance target = new ServiceCgLibInstance();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodCostTimeInterceptor());

        Object object = enhancer.create();
        System.out.println(object instanceof ServiceCgLibInstance);
        System.out.println(object.getClass() == ServiceCgLibInstance.class);
        OtherUtil.splitLinePrint();
        assert object instanceof ServiceCgLibInstance;
        ServiceCgLibInstance instance = (ServiceCgLibInstance) object;
        instance.greet("bonus");
    }

    @Test
    public void test2() {
        ServiceCgLibInstance target = new ServiceCgLibInstance();
        MethodCostTimeInterceptor2 interceptor = new MethodCostTimeInterceptor2(target);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(interceptor);

        Object object = enhancer.create();
        System.out.println(object.getClass());
        System.out.println(object instanceof ServiceCgLibInstance);
        System.out.println(object.getClass() == ServiceCgLibInstance.class);
        assert object instanceof ServiceCgLibInstance;
        ServiceCgLibInstance sc = (ServiceCgLibInstance) object;
        sc.greet("day etc.");
        System.out.println("msgLen ==> " + sc.c1("move on."));
    }

    @Test
    public void test3() {
        MyBolgModel model = new MyBolgModel("blog title...");
        System.out.println(model.getBlogTitle());
        System.out.println("博客内容:");
        System.out.println(model.getBlogContentModel().getBlogContent());
    }

    @Test
    public void test4() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DispatchModel.class);
        enhancer.setCallback(new Dispatcher() {
            @Override
            public Object loadObject() throws Exception {
                System.out.println("==> Invoke Dispatch...");
                return new DispatchModel("Mark");
            }
        });
        DispatchModel model = (DispatchModel) enhancer.create();
        model.greet("morning");
        System.out.println(model.getClass());
        OtherUtil.splitLinePrint();
        model.greet("afternoon");
        System.out.println(model.getClass());
        OtherUtil.splitLinePrint();
        model.greet("good night");
        System.out.println(model.getClass());
        OtherUtil.splitLinePrint();
    }

    @Test
    public void test5() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Foo.class);
        enhancer.setNamingPolicy(new DefaultNamingPolicy(){
            @Override
            public String getTag() {
                return "-3993-";
            }
        });
        enhancer.setCallback(NoOp.INSTANCE);
        Foo foo = (Foo)enhancer.create();
        System.out.println(foo);
    }

    @Test
    public void test6() {
        //未调用foo的默认构造函数
        Objenesis objenesis = new ObjenesisStd();
        Foo foo = objenesis.newInstance(Foo.class);
        System.out.println(foo);
        OtherUtil.splitLinePrint();
        //调用默认构造函数
        Foo foo1 = new Foo();
        System.out.println(foo1);
    }
}
