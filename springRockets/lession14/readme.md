# spring 系列第17、18篇
## 内容概要
```
@Configuration 注解加在类上可以理解为等同于一个bean 的xml文件,被该注解修饰的类会通过
CGLIB动态代理增强。加了该注解的bean才会受spring管理，对于bean上的注解如@scope才会有效，
若没加该注解则不会生效，即使加了@Scope 也没有用。

@ComponentScan注解默认的过滤器会扫描@Component、@Service、@Repository、@Controller
等注解注册成为bean,可以根据其参数设置过滤规则以确认哪些bean会注入到spring 容器中，
如可以根据basePackages、basePackageClass、Filter 等方式来筛选和控制哪些bean将被注入
到容器中
```

