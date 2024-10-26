# spring 系列第32篇
## 内容概要
* 续讲aop创建代理的方式,本文介绍ProxyFactoryBean的使用
```commandline
Spring创建代理分为2类，一种是手动方式、一种是自动方式。
一、 手动方式
1. ProxyFactory 是手动创建代理的方式。特点是需要硬编码实现，不依赖spring环境，较为灵活。
二、 自动方式
1. AspectJProxyFactory, Spring 集成了该框架, 该框架功能强大、使用方便
2. ProxyFactoryBean 用来在spring环境中给指定的bean创建代理对象，使用不太多，但可以了解
其原理, 本文主要介绍此种方式:
批量方式需要是Advisor或MethodInterceptor(包装成MethodBeforeAdvice不生效)
```