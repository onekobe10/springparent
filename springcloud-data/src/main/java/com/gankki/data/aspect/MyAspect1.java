package com.gankki.data.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;

@Aspect
public class MyAspect1 implements Ordered {

	@Override
	public int getOrder() {
		return 1;
	}

	@Pointcut("execution(* com.gankki.springboot.chapter4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
	public void manyAspects() {
	}

	@Before("manyAspects()")
	public void before() {
		System.out.println("MyAspect1 before ......");
	}

	@After("manyAspects()")
	public void after() {
		System.out.println("MyAspect1 after ......");
	}

	@After("manyAspects()")
	public void afterReturning() {
		System.out.println("MyAspect1 afterReturning ......");
	}

	@Around("manyAspects()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("1.....around before......");
		jp.proceed();
		System.out.println("1.....around after......");
	}
}
