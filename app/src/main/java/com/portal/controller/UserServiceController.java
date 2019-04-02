package com.portal.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.core.impl.UserServiceImpl;
import com.portal.core.model.User;

@RestController
@RequestMapping("/users")
public class UserServiceController {

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@GetMapping("/sort/name")
	public List<User> getUsersInSortedOrder() {
		Collection<User> users = userService.getAllUsers();
		List<User> userList =null;
			userList = users.stream().sorted((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()))
					.collect(Collectors.toList());
		return userList;
	}
	
	@GetMapping("/filter/name/{name}")
	public List<User> getUserFilterByName(@PathVariable("name") String name){
		Collection<User> users = userService.getAllUsers();
		return users.stream().filter(user -> user.getFirstName().startsWith(name)).collect(Collectors.toList());
	}
}
