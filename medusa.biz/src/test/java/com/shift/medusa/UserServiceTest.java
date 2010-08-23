package com.shift.medusa;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shift.medusa.service.UserService;
import com.shift.object.User;

public class UserServiceTest extends TestCase {

	public void testAddUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring3.xml");
		UserService userService = context.getBean("userService",
				UserService.class);
		User user = new User();
		user.setName("zhangsan");
		user.setPassword("123456");
		userService.saveUser(user);
	}

}
