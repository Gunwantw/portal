package com.portal.core.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portal.core.data.UserDAO;
import com.portal.core.model.User;
import com.portal.core.service.IUserService;

@Component
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDAO userData;

	@Override
	public void save(User user) {
		userData.save(user);
		
	}

	@Override
	public User getUser(String id) {
		return userData.getById(id);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userData.getAllUsers();
	}

}
