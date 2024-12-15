# spring 系列第15篇
## 内容概要
```
Java 动态代理有JDK 动态代理和CGLIB动态代理
1. jdk 动态代理只能代理接口，不能代理普通类。 底层使用反射API进行操作。在生成类上比较高效。
2. CGLIB 动态代理可以代理接口也可以代理普通类。底层使用ASM框架字节码实现，在类的执行过程中
比较高效。在Spring中有大量的使用，比如AOP、事务管理、Bean作用域管理确保每次返回新的实例、
@Configuration类代理，确保@Bean方法只返回单例实例
```
