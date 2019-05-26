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
#### 2.@ControllerAdvice
控制层的AOP注解，可以对@RequestMapping注解的方法进行统一的处理
1. @InitBinder 绑定一些自定义的参数，如参数转换（如将yyyy-MM-dd格式的字符串统一转成日期类型的Date）
2. @ExceptionHandler 统一对Controller层抛出的异常处理
3. @ModelAttribute 可以处理请求的参数，如增加一些全局的新参数等
ResponseBodyAdvice接口可以统一的对返回情况处理
```
@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionAdvice implements ResponseBodyAdvice
}
```
#### 日志
日志级别从低到高分为：`ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF`
1. 使用日志输出级别时应该先看看配置文件中相应的级别是否打印到了目标文件
2. 如果设置为 WARN ，则低于 WARN 的信息都不会输出。 
3. Spring Boot中默认配置ERROR、WARN和INFO级别的日志输出到控制台。 
4. 推荐使用{}占位符来代替字符串拼接，效率更高
5. ALL&OFF级别的日志一般使用
#### Spring Boot
