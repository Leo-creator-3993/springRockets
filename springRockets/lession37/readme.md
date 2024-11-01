# spring 系列第43篇
## 内容概要
* 介绍Spring 声明式事务
```
讲解spring 的声明式事务。声明式事务指的是通过配置文件或者注解的方式对接口、类、方法进行
事务声明，spring 通过aop在bean创建的时候会扫描被标注的bean，并为其生成代理。核心的注解
有：
@EnableTransactionManagement 开启spring事务管理功能
@Transactional 添加在接口、类、方法上, 只对public 方法有效
```