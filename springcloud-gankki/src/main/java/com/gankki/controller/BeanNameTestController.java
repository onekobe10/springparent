package com.gankki.controller;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Controller;

@Controller("beanNameTest")
public class BeanNameTestController implements BeanNameAware {

	@Override
	public void setBeanName(String beanName) {
		System.out.println(beanName + "..................................");
	}

}
