package com.portal.rest.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.core.model.User;
import com.portal.core.service.IUserService;
import com.portal.core.util.CurrentPrincipalLoggerUtil;

@RestController
@RequestMapping("/api/users")
public class UserServiceController {

	Log logger = LogFactory.getLog(getClass());
	@Autowired
	//@Qualifier(value = "adminUserServiceImpl")
	IUserService userService;

	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		logCurrentPrincipal();
		return userService.getUser(id);
	}

	@GetMapping("/sort/name")
	public List<User> getUsersInSortedOrder() {
		logCurrentPrincipal();
		return userService.getUsersSortByName();
	}
	
	@GetMapping("/filter/name/{filter}")
	public List<User> getUserFilterByName(@PathVariable("filter") String filter){
		logCurrentPrincipal();
		return userService.getUsersFilterByName(filter);
	}
	
	@GetMapping("/sort/dob")
	public List<User> getUserSortedByDob(){
		logCurrentPrincipal();
		return userService.getUsersSortByDob();
	}
	
	private void logCurrentPrincipal() {
		UserDetails userDetail =CurrentPrincipalLoggerUtil.getCurrentPrincipalUserDetails();
		logger.info("===============Executing Request For User ==============="+ userDetail.getUsername());
	}
}
