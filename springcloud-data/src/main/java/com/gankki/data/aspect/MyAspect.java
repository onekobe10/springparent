package com.gankki.data.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;

@Aspect
public class MyAspect implements Ordered {


	@Pointcut("execution(* com.gankki.springboot.chapter4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void before() {
		System.out.println("4......before ......");
	}

	@After("pointCut()")
	public void after() {
		System.out.println("4.....after ......");
	}


	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("4.....afterReturning ......");
	}

	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("4.....afterThrowing ......");
	}


	@Around("pointCut()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("4.....around before......");
		jp.proceed();
		System.out.println("4.....around after......");
	}

	@Override
	public int getOrder() {
		return 4;
	}
}
