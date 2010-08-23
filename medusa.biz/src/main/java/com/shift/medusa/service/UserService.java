package com.shift.medusa.service;

import java.util.List;

import com.shift.object.User;

public interface UserService {

	public void saveUser(User user);
	
	public List<User> getAllUsers();

}
