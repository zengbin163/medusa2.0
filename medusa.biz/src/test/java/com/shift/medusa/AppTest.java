package com.shift.medusa;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shift.medusa.BaseBean;

/**
 * Hello world!
 * 
 */
public class AppTest extends TestCase {
	public void testMain() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring3.xml");
		BaseBean beanContainer = context.getBean("beanContainer",
				BaseBean.class);
		beanContainer.baseMethod();
		/***
		 * ExpressionParser parser = new SpelExpressionParser(); Expression
		 * expression1 = parser.parseExpression("'hello'.concat('world')");
		 * Expression expression2 =
		 * parser.parseExpression("'hello'.bytes.length");
		 * System.out.println(expression1.getValue());
		 * System.out.println(expression2.getValue());
		 * System.out.println("'hello'.concat('world')");
		 ***/
	}
}
