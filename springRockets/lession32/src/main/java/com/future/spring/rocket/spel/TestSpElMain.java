package com.future.spring.rocket.spel;

import com.future.spring.rocket.common.util.OtherUtil;
import com.future.spring.rocket.spel.test1.LessionModel;
import com.future.spring.rocket.spel.test1.MainConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.*;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.*;

public class TestSpElMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    @Test
    public void test1() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("('Foo').concat(#foo)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("foo", "Foo");
        System.out.println(expression.getValue(context));
    }

    @Test
    public void test2() {
        ExpressionParser parser = new SpelExpressionParser();
        ParserContext parserContext = new ParserContext() {
            @Override
            public boolean isTemplate() {
                return true;
            }

            @Override
            public String getExpressionPrefix() {
                return "#{";
            }

            @Override
            public String getExpressionSuffix() {
                return "}";
            }
        };

        String template = "#{'Leo'}#{'Leo'}";
        Expression expression = parser.parseExpression(template, parserContext);
        System.out.println(expression.getValue());
    }

    @Test
    public void test3() {
        ExpressionParser parser = new SpelExpressionParser();
        String str1 = parser.parseExpression("'FooFoo'").getValue(String.class);
        int int1 = parser.parseExpression("42").getValue(Integer.class);
        long long1 = parser.parseExpression("-1000L").getValue(Long.class);
        float float1 = parser.parseExpression("-23.24f").getValue(Float.class);
        double double1 = parser.parseExpression("1.1E+2").getValue(Double.class);
        int hex1 = parser.parseExpression("0xA").getValue(Integer.class);
        long hex2 = parser.parseExpression("0xaL").getValue(Long.class);
        boolean true1 = parser.parseExpression("true").getValue(boolean.class);
        boolean false1 = parser.parseExpression("false").getValue(boolean.class);
        Object null1 = parser.parseExpression("null").getValue(Object.class);

        System.out.println(String.format("str1 => %s, int1 => %s, long1 => %s, float1 => %s, " +
                        "\n double1 => %s, hex1 => %s, hex2 => %s, true1 => %s, " +
                        "\nfalse1 => %s, null1 => %s",
                str1, int1, long1, float1, double1, hex1, hex2, true1, false1, null1));

    }

    @Test
    public void test4() {
        ExpressionParser parser = new SpelExpressionParser();
        boolean v1 = parser.parseExpression("1 > 2").getValue(boolean.class);
        boolean between1 = parser.parseExpression("1 between {1,2}").getValue(boolean.class);
        System.out.println("v1=" + v1);
        System.out.println("between1=" + between1);
        OtherUtil.splitLinePrint();

        System.out.println(parser.parseExpression("2 > 1 and (!true or !false)").getValue(boolean.class));
        System.out.println(parser.parseExpression("2 > 1 && (!true or !false)").getValue(boolean.class));
        System.out.println(parser.parseExpression("2 > 1 && (NOT true or Not false)").getValue(boolean.class));
        System.out.println(parser.parseExpression("2 > 1 and (NOT true and Not false)").getValue(boolean.class));
    }

    @Test
    public void test5() {
        ExpressionParser parser = new SpelExpressionParser();
        Class<String> result1 = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(result1);

        String esp2 = "T(com.future.spring.rocket.spel.TestSpElMain)";
        Class<TestSpElMain> value = parser.parseExpression(esp2).getValue(Class.class);
        System.out.println(value);

        int result3 = parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
        System.out.println(result3);

        int result4 = parser.parseExpression("T(Integer).parseInt('1')").getValue(int.class);
        System.out.println(result4);
    }

    @Test
    public void testConstructorExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        String result1 = parser.parseExpression("new String('FooFoo')").getValue(String.class);
        System.out.println(result1);

        Date result2 = parser.parseExpression("new java.util.Date()").getValue(Date.class);
        System.out.println(result2);
    }

    @Test
    public void testInstanceOfExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        Boolean value = parser.parseExpression("'路人甲' instanceof T(String)").getValue(Boolean.class);
        System.out.println(value);
    }

    @Test
    public void testVariableExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name", "LeoLeo");
        context.setVariable("age", "18");

        String name = parser.parseExpression("#name").getValue(context, String.class);
        System.out.println(name);

        int age = parser.parseExpression("#age").getValue(context, Integer.class);
        System.out.println(age);

        context = new StandardEvaluationContext("我是root Object");
        String rootObj = parser.parseExpression("#root").getValue(context, String.class);
        System.out.println(rootObj);

        String thisObj = parser.parseExpression("#this").getValue(context, String.class);
        System.out.println(thisObj);
    }

    @Test
    public void testFunctionExpression() throws NoSuchMethodException {
        StandardEvaluationContext context = new StandardEvaluationContext();
        Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);
        context.registerFunction("parseInt1", parseInt);
        context.registerFunction("foo", parseInt);

        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("#parseInt1('42')").getValue(context, int.class));
        System.out.println(parser.parseExpression("#foo('3993')").getValue(context, int.class));

        String exp1 = "#parseInt1('3993') == #foo('3993')";
        boolean result1 = parser.parseExpression(exp1).getValue(context, boolean.class);
        System.out.println(result1);

    }

    @Test
    public void testAssignExpression1() {

        Object user = new Object() {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "$className{" +
                        "name='" + name + '\'' +
                        '}';
            }
        };

        {
            ExpressionParser parser = new SpelExpressionParser();
            EvaluationContext context = new StandardEvaluationContext(user);
            parser.parseExpression("#root.name").setValue(context, "LeoLeo");
            System.out.println(parser.parseExpression("#root").getValue(context, user.getClass()));
        }

        {
            ExpressionParser parser = new SpelExpressionParser();
            EvaluationContext context = new StandardEvaluationContext();
            context.setVariable("user", user);
            parser.parseExpression("#user.name").setValue(context, "FooFoo");
            System.out.println(parser.parseExpression("#user").getValue(context, user.getClass()));
        }
    }

    public static class Car {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class User {
        private Car car;

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        @Override
        public String toString() {
            return "User{" +
                    "car=" + car +
                    '}';
        }
    }

    @Test
    public void  test7() {
        User user = new User();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("user", user);
        ExpressionParser parser = new SpelExpressionParser();
        try {
            System.out.println(parser.parseExpression("#user.car.name").getValue(context,String.class));
        } catch (EvaluationException | ParseException e) {
            System.out.println("出错了:" + e.getMessage());
        }

        //安全访问？规避null错误
        System.out.println(parser.parseExpression("#user?.car?.name").getValue(context, String.class));
        Car car = new Car();
        car.setName("BYD");
        user.setCar(car);

        System.out.println(parser.parseExpression("#user?.car?.toString()").getValue(context, String.class));
    }

    @Test
    public void test8() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        User user = new User();
        Car car = new Car();
        car.setName("WLHongG");
        user.setCar(car);
        factory.registerSingleton("user", user);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(factory));

        ExpressionParser parser = new SpelExpressionParser();
        User userBean = parser.parseExpression("@user").getValue(context, User.class);
        System.out.println(userBean);
        System.out.println(userBean == factory.getBean("user"));
    }

    @Test
    public void test9() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> result1 = parser.parseExpression("{}").getValue(List.class);
        List<Integer> result2 = parser.parseExpression("{1,2,3}").getValue(List.class);
        System.out.println(result1 + " => " + result2);

        String exp3 = "{{1+2,5}, {3, 3+4}}";
        List<List<Integer>> result3 = parser.parseExpression(exp3).getValue(List.class);
        System.out.println("Before result3 => " + result3);
        result3.get(0).set(0,1);
        System.out.println("After result3 => " + result3);

        int[] result4 = parser.parseExpression("new int[2] {1,2}").getValue(int[].class);
        System.out.println(result4[1]);

        int[] result5 = parser.parseExpression("new int[1]").getValue(int[].class);
        System.out.println(result5[0]);
    }

    @Test
    public void test10() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        EvaluationContext context1 = new StandardEvaluationContext();
        context1.setVariable("c1", list);
        parser.parseExpression("#c1[1]").setValue(context1, 42);
        int result1 = parser.parseExpression("#c1[1]").getValue(context1, int.class);
        System.out.println(result1);

        Map<String, Integer> map = new HashMap<>();
        map.put("leo", 18);
        EvaluationContext context2 = new StandardEvaluationContext();
        context2.setVariable("map", map);
        parser.parseExpression("#map['leo']").setValue(context2, 42);
        int result2 = parser.parseExpression("#map['leo']").getValue(context2, int.class);
        System.out.println(result2);
    }

    @Test
    public void test11() {
        ExpressionParser parser = new SpelExpressionParser();

        List<Integer> list = new ArrayList<>();
        list.add(99);
        list.add(199);

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("list", list);

        Collection<Integer> result1 = parser.parseExpression("#list.![#this+1]").getValue(context, Collection.class);
        result1.forEach(System.out::println);

        Map<String, Integer> map = new HashMap<>();
        map.put("leo", 17);
        map.put("foo", 41);

        EvaluationContext context1 = new StandardEvaluationContext();
        context1.setVariable("map", map);
        List<Integer> result2 = parser.parseExpression("#map.![value +1]").getValue(context1, List.class);
        result2.forEach(System.out::println);
    }

    @Test
    public void test12() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> list = new ArrayList<>();
        list.add(42);
        list.add(18);
        list.add(23);
        list.add(24);

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("list", list);
        Collection<Integer> result1 = parser.parseExpression("#list.?[#this > 20]").getValue(context, Collection.class);
        result1.forEach(System.out::println);
    }

    @Test
    public void test13() {

        SpelExpressionParser parser = new SpelExpressionParser();
        ParserContext context = new TemplateParserContext("%{", "}");
        Expression expression = parser.parseExpression("Hello:%{#name}, %{#foo}", context);
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("name", "Leo");
        evaluationContext.setVariable("foo", "FooFoo");

        String value = expression.getValue(evaluationContext, String.class);
        System.out.println(value);
    }

    @Test
    public void test14() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        LessionModel lessionModel = context.getBean(LessionModel.class);
        System.out.println(lessionModel);
    }



}


