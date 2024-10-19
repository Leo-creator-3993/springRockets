# spring 系列第28篇
## 内容概要
* 主要包括BeanDefinitionRegistryPostProcessor和BeanFactoryPostProcessor
```commandline
1. spring在bean注册完成后, 会对BeanDefinitionRegistryPostProcessor类型的bean 进行
调用, 预留了接口给开发者, 例如可以实现该类型的bean额外注入bean

2. spring在BeanFactoryPostProcessor后置阶段,会对该类型的bean进行调用,给开发者预留接口,可以修改bean
的定义信息。但是要特别注意的是不能通过beanFactory 去获取bean, 因为导致bean 的提前初始化
从而引发问题, 例如该bean依赖了其他bean, 而其他bean未初始化好
```