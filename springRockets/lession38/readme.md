# spring 系列第44篇
## 内容概要
* Spring 事务的源码讲解
```
继续讲解spring 的事务。核心类:
PlatformTransactionManager
TransactionDefinition
JdbcTemplate

它们将共用一个Datasource, 预留给开发者扩展点的类:
TransactionSynchronizationManager
```