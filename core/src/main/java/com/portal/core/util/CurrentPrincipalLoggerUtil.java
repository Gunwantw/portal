package com.portal.core.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class CurrentPrincipalLoggerUtil {
	
	public static UserDetails getCurrentPrincipalUserDetails() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return (UserDetails)principal;
	}

}
