# Spring Bean 加载顺序

# @Configuraiton & @Bean 的使用

# @ConfigurationProperties @EnableConfigurationProperties
> 三种方式可以将 @ConfigurationProperties 标识的配置属性注入到 Spring 容器中：
> 1. @Component &  @ConfigurationProperties 
> 2. @Configuration & @Bean
> 3. @ConfigurationProperties & @EnableConfigurationProperties 可以将 Spring 扫描不到的配置对象注入到当前容器中
> 4. @ConfigurationProperties & @Bean 