package com.portal.core.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.core.data.UserDAO;
import com.portal.core.model.User;
import com.portal.core.service.IUserService;

@Service
public class AdminUserServiceImpl implements IUserService { 
	@Autowired
	private UserDAO userData;

	@Override
	public void save(User user) {
		userData.save(user);
	}

	@Override
	public User getUser(String id) {
		System.out.println("=======AdminUserServiceImpl==========");
		return userData.getById(id);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userData.getAllUsers();
	}

	@Override
	public List<User> getUsersSortByName() {
		Collection<User> users = userData.getAllUsers();
		List<User> userList = null;
		userList = users.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());
		return userList;
	}

	@Override
	public List<User> getUsersFilterByName(String filter) {
		Collection<User> users = userData.getAllUsers();
		return users.stream().filter(user -> user.getName().startsWith(filter)).collect(Collectors.toList());
	}

	@Override
	public List<User> getUsersSortByDob() {
		Collection<User> users = userData.getAllUsers();
		return users.stream().sorted((user1, user2) -> {
			if (user1.getDateOfBirth() > user2.getDateOfBirth()) {
				return 1;
			} else if (user1.getDateOfBirth() < user2.getDateOfBirth()) {
				return -1;
			} else {
				return 0;
			}
		}).collect(Collectors.toList());
	}
}
