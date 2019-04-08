package com.gankki.configuration;

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
