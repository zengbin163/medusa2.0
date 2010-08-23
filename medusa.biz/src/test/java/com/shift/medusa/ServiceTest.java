package com.shift.medusa;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shift.medusa.service.UserService;
import com.shift.object.User;

public class ServiceTest extends TestCase {
	public void testMain() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring3.xml");
		UserService userService = context.getBean("userService",
				UserService.class);
		List<User> list = userService.getAllUsers();
		System.out.println(list.size());
	}
}
