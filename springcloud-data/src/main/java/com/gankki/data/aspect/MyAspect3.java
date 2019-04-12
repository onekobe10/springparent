package com.gankki.data.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3)
public class MyAspect3 implements Ordered {

	@Pointcut("execution(* com.gankki.data.aspect.service.impl.UserServiceImpl.manyAspects(..))")
	public void manyAspects() {
	}

	@Before("manyAspects()")
	public void before() {
		System.out.println("MyAspect3 before ......");
	}

	@After("manyAspects()")
	public void after() {
		System.out.println("MyAspect3 after ......");
	}

	@After("manyAspects()")
	public void afterReturning() {
		System.out.println("MyAspect3 afterReturning ......");
	}

	@Override
	public int getOrder() {
		return 3;
	}

	@Around("manyAspects()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("3.....around before......");
		jp.proceed();
		System.out.println("3.....around after......");
	}
}
