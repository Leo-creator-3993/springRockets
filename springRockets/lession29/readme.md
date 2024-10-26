# spring 系列第35篇
## 内容概要
* 介绍@EnableAspectJAutoProxy的用法
```commandline
Spring 通过@EnableAspectJAutoProxy 来批量添加代理拦截，结合@AspectJ 注解，对
目标对象进行增强。当有多个@AspectJ时，以Order 升序排序。@AspectJ 内部的执行顺序
为：
@AfterThrowing
@AfterReturning
@After
@Around
@Before
```