# spring 系列第42篇
## 内容概要
* 介绍Spring 事务
```
spring 事务有2种使用方式, 一种是编程式事务、一种是声明式事务
声明式事务使用较为方便, 通过注解方式, 技术侧使用AOP实现, 底层调用编程式事务所依赖的接口
编程式事务是手动的方式,比较核心的几个类包括:
PlatformTranscationManager -- 事务管理器
TransactionDefinition -- 事务属性，包括事务传播、隔离级别等
TransactionStatus -- 表示事务状态的对象
JdbcTemplate -- 用于具体的操作数据库的封装对象
TransactionTemplate -- Spring 进行封装,省去了提交和回滚的代码
```