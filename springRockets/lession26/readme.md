# spring 系列第30篇
## 内容概要
* 讲解spring aop的原生基础使用方式
```commandline
spring aop形象的理解就是在多个控制流中插入一个切面。具体而言就是可以在一批方法执行
前、执行后、执行结果返回后插入一些公共的处理逻辑。比如说打日志,需要统计所有调用方法
的日志耗时等。
1. Joinpoint用于连接多个advise
2. Advise 定义了在方法的何处(前、后、异常)做什么事情
3. Methodinterceptor 可以构成一个拦截器链
4. Pointcut用来定义切面的位置,和Advise可以一起组成Advisor
5. Advisor将Pointcut和Advise组合起来
```