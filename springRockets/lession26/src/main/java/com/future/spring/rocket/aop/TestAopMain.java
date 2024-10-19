package com.future.spring.rocket.aop;

import com.future.spring.rocket.aop.test1.AopUserService;
import com.future.spring.rocket.common.util.OtherUtil;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.jupiter.api.Test;
import org.springframework.aop.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

public class TestAopMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
               return AopUserService.class::isAssignableFrom;
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return "greet".equals(method.getName());
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> aClass, Object... objects) {
                        return false;
                    }
                };
            }
        };

        Advice advice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("你好," + objects[0]);
            }
        };

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new AopUserService());
        proxyFactory.addAdvisor(advisor);

        AopUserService userService = (AopUserService) proxyFactory.getProxy();
        userService.greet("Leo");
        OtherUtil.splitLinePrint();
        userService.foo();
    }

    @Test
    public void test2() {
        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return AopUserService.class::isAssignableFrom;
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return "greet".equals(method.getName());
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> aClass, Object... objects) {
                        return false;
                    }
                };
            }
        };

        ProxyFactory proxyFactory = getProxyFactory(pointcut);

        AopUserService userService = (AopUserService) proxyFactory.getProxy();
        userService.greet("Leo");
        OtherUtil.splitLinePrint();
        userService.foo();
    }

    @Test
    public void test3() {
        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return AopUserService.class::isAssignableFrom;
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return "greet".equals(method.getName());
                    }

                    @Override
                    public boolean isRuntime() {
                        return true;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> aClass, Object... objects) {
                        return "Leo".equals(objects[0]);
                    }
                };
            }
        };

        Advice advice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("你好," + objects[0]);
            }
        };

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new AopUserService());
        proxyFactory.addAdvisor(advisor);

        AopUserService userService = (AopUserService) proxyFactory.getProxy();
        userService.greet("Leo");
        OtherUtil.splitLinePrint();
        userService.greet("Mark");
        OtherUtil.splitLinePrint();
        userService.foo();
    }

    private static ProxyFactory getProxyFactory(Pointcut pointcut) {
        Advice advice = (MethodInterceptor) methodInvocation -> {
            String methodName = methodInvocation.getMethod().getName();
            System.out.println("Before invoke method ==> " + methodName);
            long startTime = System.nanoTime();
            methodInvocation.proceed();
            System.out.println("Finish invoke method ==> " + methodName + ", useTime ==> " + (System.nanoTime() - startTime) +  " ns.");
            return null;
        };

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new AopUserService());
        proxyFactory.addAdvisor(advisor);
        return proxyFactory;
    }
}
