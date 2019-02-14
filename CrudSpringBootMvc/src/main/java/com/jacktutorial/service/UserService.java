package com.jacktutorial.service;

import java.util.List;

import com.jacktutorial.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public User getUserById(long id);
	
	public User getUserByAliasAndPassword(String alias, String password);

	public void saveOrUpdate(User user);

	public void deleteUser(long id);
}
