package com.shift.medusa;

import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Administrator
 * 
 */
@Configuration
public class BeanContainer implements BaseBean {
	public String getBeans() {
		System.out.println("method");
		return "Oh God";
	}

	@Override
	public void baseMethod() {
		System.out.println("base method");
	}

}
