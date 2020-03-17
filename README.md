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
#### 如何实现跨域
1. 服务器端运行跨域 设置响应头信息 CORS 等于 *，否则前端会报错；
2. 在单个接口使用注解 @CrossOrigin 运行跨域；
3. 使用 jsonp 跨域；
#### @Transactional
1.添加位置
1. 接口实现类或接口实现方法上，而不是接口类中。
2. 访问权限：public 的方法才起作用。@Transactional 注解应该只被应用到 public 方法上，这是由 Spring AOP 的本质决定的。
系统设计：将标签放置在需要进行事务管理的方法上，而不是放在所有接口实现类上：只读的接口就不需要事务管理，由于配置了@Transactional就需要AOP拦截及事务的处理，可能影响系统性能。

2.其他说明
1. Spring 默认只有在抛出非受检异常（NullPointerException extends RuntimeException）及Error异常时才会导致事务回滚，抛出的受检（IOException extends Exception）异常不会导致事务回滚。
2. 我们可以设置 rollbackFor = Exception.class，任何抛出的异常都会导致事务回滚。
3. @Transactional 是由 Spring AOP 实现的，类内部方法调用是无效的，需要通过代理对象调用方法(1.注入当前类的实例2.获取当前类的代理对象)。

3.属性解读
```
@AliasFor("transactionManager")
String value() default "";

@AliasFor("value")
String transactionManager() default ""; 设置当前会话的事务管理器
主要用来指定不同的事务管理器，适用场景：在一个系统中，需要访问多个数据源或者多个数据库，则必然会配置多个事务管理器的

Propagation propagation() default Propagation.REQUIRED; 设置当前会话的事务传播行为
REQUIRED(0),        // 如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
SUPPORTS(1),        // 如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
MANDATORY(2),       // 如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
REQUIRES_NEW(3),    // 创建一个新的事务，如果当前存在事务，则把当前事务挂起。
NOT_SUPPORTED(4),   // 以非事务方式运行，如果当前存在事务，则把当前事务挂起。
NEVER(5),           // 以非事务方式运行，如果当前存在事务，则抛出异常。
NESTED(6);          // 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；
                       如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。

Isolation isolation() default Isolation.DEFAULT; 设置当前会话的事务隔离级别
默认使用数据库设置的隔离级别，也可以为当前会话独立设置隔离级别
DEFAULT(-1),
READ_UNCOMMITTED(1),    // 读未提交
READ_COMMITTED(2),      // 读已提交
REPEATABLE_READ(4),     // 可重复读
SERIALIZABLE(8);        // 序列化
    
int timeout() default -1; 设置当前事务的超时时间

boolean readOnly() default false; 设置是否为只读事务

Class<? extends Throwable>[] rollbackFor() default {}; 设置导致事务回滚的异常类数组

String[] rollbackForClassName() default {}; 设置事务回滚的异常类名称数组

Class<? extends Throwable>[] noRollbackFor() default {}; 设置不会导致事务回滚的异常类数组

String[] noRollbackForClassName() default {}; 设置不会导致事务回滚的异常类名称数组
```