# spring 系列第36篇
## 内容概要
* 介绍@EnableAsync和@Async的用法
```commandline
- @Async标注方法表示异步执行,标注类上则所有方法是异步的
- @EnableAsync 表示开启异步执行的开关,标注在配置类上
- 可以自定义线程池, 定义一个taskExecutor的bean 或者实现AsyncConfigurer 
- 线程池可以隔离, 不同的方法或者类可以指定使用不同的线程池, 在@Async中进行指定
- 异步处理分为无返回值和有返回值,有返回值使用Future包装,对于有返回值的异常处理使用
  try...catch, 无返回值的异常处理可以在AsyncConfigurer的handle方法中处理
- @Async 和 @EnableAsync 的底层实现原理是使用Aop来实现的
```