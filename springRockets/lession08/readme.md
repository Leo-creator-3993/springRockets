# spring 系列第11篇
## 内容概要
```
spring处理依赖时，bean的autowire-candidate默认值时true，当有多个类型的bean满足要求时，
spring 会去找被标注为primary的bean类型，当找到时则以该bean进行注入。在有多个类型bean满足
要求的情况下可以通过设置autowire-candidate 只有一个为true，其他都为false，则spring取设置
为true的bean作为注入。

如果primary 和autowire-candidate 同时满足要求的情况下，经过测试，autowire-candidate的
优先级高于primary。如下例子将注入ServiceB,即被autowire-candidate所标注的bean。

<bean id="serviceA" class="com.future.spring.rocket.entity.AutowireCandidateModel$ServiceA" autowire-candidate="false" primary="true"/>
<bean id="serviceB" class="com.future.spring.rocket.entity.AutowireCandidateModel$ServiceB" autowire-candidate="true"/>
<bean id="autowireCandidateModel" class="com.future.spring.rocket.entity.AutowireCandidateModel" autowire="byType"/>
```

