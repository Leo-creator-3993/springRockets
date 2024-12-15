# spring 系列第23篇
## 内容概要
```
springmvc 包含有父子容器的结构设计，通常service层和dao层的bean在父容器中，而controller 层
的bean在子容器中。 这里有一条规则:
1. 子容器可以访问父容器中的bean, 而父容器则无法访问子容器中的bean。
springmvc 采用父子容器的设计结构防止了将controller 层的bean 注入到service层或者dao层，从
而引发依赖问题

2.BeanFactory支持层次查找, ListableBeanFactory不支持层次查找,BeanFactoryUtils作为工具
类提供常用方法
```

