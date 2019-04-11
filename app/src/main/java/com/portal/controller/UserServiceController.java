package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.core.model.User;
import com.portal.core.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserServiceController {

	@Autowired
	//@Qualifier(value = "adminUserServiceImpl")
	IUserService userService;

	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		System.out.println(userService.hashCode());
		return userService.getUser(id);
	}

	@GetMapping("/sort/name")
	public List<User> getUsersInSortedOrder() {
		System.out.println(userService.hashCode());
		return userService.getUsersSortByName();
	}
	
	@GetMapping("/filter/name/{filter}")
	public List<User> getUserFilterByName(@PathVariable("filter") String filter){
		return userService.getUsersFilterByName(filter);
	}
	
	@GetMapping("/sort/dob")
	public List<User> getUserSortedByDob(){
		return userService.getUsersSortByDob();
	}
}
