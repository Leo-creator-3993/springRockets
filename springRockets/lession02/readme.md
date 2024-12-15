# spring 系列第4、5篇
## 内容概要
```
从spring 系列第4篇开始
第4篇主要介绍bean 的别名
1. 有id、name 时别名是name
2. 没id、没name时别名自动生成
3. 可以通过alais来指定别名

第5篇介绍创建bean实例的方式
1. 通过反射调用构造方法
<bean id="bean名称" name="bean名称或者别名" class="bean的完整类型名称">
    <constructor-arg index="0" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="1" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="2" value="bean的值" ref="引用的bean名称" />
    ....
    <constructor-arg index="n" value="bean的值" ref="引用的bean名称" />
</bean>


2. 通过静态工厂
<bean id="bean名称" name="" class="静态工厂完整类名" factory-method="静态工厂的方法">
    <constructor-arg index="0" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="1" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="2" value="bean的值" ref="引用的bean名称" />
    ....
    <constructor-arg index="n" value="bean的值" ref="引用的bean名称" />
</bean>

3. 通过实例工厂
<bean id="bean名称" factory-bean="需要调用的实例对象bean名称" factory-method="bean对象中的方法">
    <constructor-arg index="0" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="1" value="bean的值" ref="引用的bean名称" />
    <constructor-arg index="2" value="bean的值" ref="引用的bean名称" />
    ....
    <constructor-arg index="n" value="bean的值" ref="引用的bean名称" />
</bean>


4. 通过FactoryBean方式
<bean id="bean名称" class="FactoryBean接口实现类" />
```

