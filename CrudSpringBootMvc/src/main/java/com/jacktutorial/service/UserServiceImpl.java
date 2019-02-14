package com.jacktutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacktutorial.model.User;
import com.jacktutorial.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public User getUserByAliasAndPassword(String alias, String password) {
		//List<User> users=userRepository.findByAliasAndPassword(alias,password);
		List<User> users=userRepository.findByQuery(alias,password);
		if(users!=null && !users.isEmpty()) {
			return users.get(0);
		}else return null;
	}

	@Override
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

}
