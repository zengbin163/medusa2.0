package com.shift.medusa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;

import com.shift.medusa.dao.UserDao;
import com.shift.medusa.service.UserService;
import com.shift.object.User;

@Configuration("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public void saveUser(User user) {
		userDao.insertUser(user);
	}

	public List<User> getAllUsers() {
		return userDao.queryAllUsers();
	}

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
