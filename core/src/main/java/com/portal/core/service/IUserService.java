package com.portal.core.service;

import java.util.Collection;

import com.portal.core.model.User;

public interface IUserService {
	public void save(User user);
	public User getUser(String id);
	public Collection<User> getAllUsers();
}
