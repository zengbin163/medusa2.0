package com.shift.medusa;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeanAspect {
	@Pointcut("execution(public * com.shift.medusa.service..*(..))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void before() {
		System.out.println("before");
	}

	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("after returning");
	}

	public void around() {
		System.out.println("around");
	}
}
