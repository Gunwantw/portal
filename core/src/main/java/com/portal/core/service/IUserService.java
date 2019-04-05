package com.portal.core.service;

import java.util.Collection;
import java.util.List;

import com.portal.core.model.User;

public interface IUserService {
	public void save(User user);
	public User getUser(String id);
	public Collection<User> getAllUsers();
	public List<User> getUsersSortByName();
	public List<User> getUsersFilterByName(String filter);
	public List<User> getUsersSortByDob();
}
