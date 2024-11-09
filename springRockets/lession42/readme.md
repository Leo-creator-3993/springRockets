# spring 系列第50篇
## 内容概要
- spring 集成mybatis内容概要,介绍Spring 集成mybatis, 核心要点:
1. @Mapper 注解设置了操作db 的接口
2. @MapperScan 注解将@Mapper标注的类注入到spring中, 同时也可以设置SqlSessionFactoryBean
   实现多个数据库的操作, 但一般实践用的不对,作为了解即可
3. 注入DataSource 、 TranscationManager、SqlSessionFactoryBean 的bean
4. mapper xml 文件需要在SqlSessionFactoryBean中进行指定以扫描, 还有注解的使用方式
