package com.gankki.controller;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Controller;

@Controller("ssss")
public class BeanNameTestController implements BeanNameAware {

	@Override
	public void setBeanName(String s) {
		System.out.println(s + "..................................");
	}
}
