# spring 系列第47、48、49篇
## 内容概要
- spring 事务在哪些场景下会失效？
1. 未开启@EnableTransactionManagement
2. @Transactional 未用在public 方法上
3. 未注入事务管理器的bean @PlatformTransactionManagement
4. 业务代码和事务管理的代码不在一个线程中, spring使用treadLocal来管理事务
5. 异常类型不正确。spring 事务对RuntimeException和Error 异常进行回滚
6. 异常被吞了。在业务代码中使用try catch 捕获了异常,导致没有触发回滚逻辑
7. 自身调用问题。必须是被spring 代理增强的对象事务才会生效

- 如何快速定位异常？
1. 开启debug 日志调测
2. debug 源代码

- spring 实现db的读写分离
