package com.iu.s1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect	//advice 위치
public class CustomAOP {

														//. 이면 매개변수가 1개인것
	@Before("execution(* com.iu.s1.board.notice.*Service.*(..))")
	public void before() throws Exception{
		System.out.println("Before Method");
	}
	
	@AfterReturning("execution(* com.iu.s1.board.notice.*Service.get*(..))")
	public void afterReturning() throws Exception{
		System.out.println("AfterReturning Method");
	}
	
	@AfterThrowing("execution(* com.iu.s1.board.notice.*Service.get*(..))")
	public void afterThrowing() throws Exception{
		System.out.println("AfterThrowing Method");
	}
	
	@After("execution(* com.iu.s1.board.notice.*Service.get*(..))")
	public void after() throws Exception{
		System.out.println("After Method");
	}
	
	@Around("execution(* com.iu.s1.board.notice.*Service.get*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Before");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("After");
		
		return obj;
	}
}
