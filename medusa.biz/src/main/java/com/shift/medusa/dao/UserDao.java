package com.shift.medusa.dao;

import java.util.List;

import com.shift.object.User;

public interface UserDao {

	public void insertUser(User user);
	
	public List<User> queryAllUsers();

}
