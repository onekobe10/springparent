package com.gankki.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor 测试
 * @author liuhao
 * @date 2020/3/16
 */
public class BeanConfig  implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("前置。。。。。。。。。。。。" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("后置。。。。。。。。。。。。" + beanName);
		return bean;
	}
}
