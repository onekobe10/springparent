package com.gankki.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *@desc  Bean的加载顺序
 *@author liuhao
 *@createDate 2019/3/1
 */
public class HelloWorld  implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
		InitializingBean, DisposableBean {

	private ApplicationContext applicationContext;

	@Override
	public void setBeanName(String beanName) {
		System.out.println(beanName + "1.......");
	}

	/**
	 * Bean拥有访问Spring容器的能力
	 * 导致代码与spring的api耦合在一起，这种方式不推荐
	 * @param beanFactory
	 * @throws BeansException
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * 在一个单例Bean里可以通过这种方式每次都能得到一个新的Object对象
	 * 但是没必要，无状态bean，单例的就可以了。
	 */
	public void doSomething() {
		System.out.println("AccountServiceImpl#doSomething......");
		System.out.println("getAccountDao....."+ getAccountDao().toString());

	}

	/**
	 * 每次调用此方法从应用上下文中获取一个新的Object对象。
	 * @return
	 */
	private Object getAccountDao(){
		return applicationContext.getBean(Object.class);
	}

	@PostConstruct
	public void init(){
		System.out.println("初始化方法1");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("初始化方法2");
	}

	@PreDestroy
	public void preDestroy(){
		System.out.println("preDestroy.........销毁方法1");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy.........销毁方法2");
	}
}
