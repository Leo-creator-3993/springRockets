# spring 系列第25篇
## 内容概要
```
1. 如何使用spring的国际化
2. 国际化配置变更了如何刷新
3. 国际化放置于db如何获取
Locale -> 国家_地区 -> zh_CN 、en_UK、en_US等
配置国际化资源文件、注入资源绑定的bean(告知spring从何获取)、ApplicationContext 已实现
了国际化的接口MessageSource

简而言之, 注入一个MessageSource 的Bean 到Spring, bean的名称必须为messageSource,
则可以通过applicationContext 获取到国际化的信息了
```

