# springparent
Spring series project from Gankki

liuhao7794@163.com

#### 1. AOP
spring.aop.auto=true # Add @EnableAspectJAutoProxy.
spring.aop.proxy-target-class=true # Whether subclass-based (CGLIB) proxies are to be created (true), as opposed to standard Java interface-based proxies (false).
Spring Boot的默认配置，相当于全局的注解配置@EnableAspectJAutoProxy(proxyTargetClass = true)
1. 说明了默认使用AspectJ的Aop框架来实现Spring的AOP
2. 默认使用CGLIB的动态代理，即使有统一的接口
>Spring生态中默认使用Cglib动态代理作为主要的动态代理方式——不是java原生的java.lang.reflect.Proxy动态代理。无论被代理的Bean实例是否实现了任何接口，Cglib都能更好胜任代理工作任务。
