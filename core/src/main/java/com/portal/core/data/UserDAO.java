package com.portal.core.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.portal.core.model.User;

@Repository
public class UserDAO {

	private Map<String,User> users = new HashMap<>();
	
	public UserDAO() {
		users.put("xyz", new User("xyz","xyz",837493847934l));
		users.put("123", new User("123","xyz",837493847934l));
		users.put("145", new User("145","xyz",837493847934l));
		users.put("167", new User("167","xyz",837493847934l));
		users.put("178", new User("178","xyz",837493847934l));
		users.put("234", new User("234","xyz",837493847934l));
		users.put("245", new User("245","xyz",837493847934l));
	}
	
	public User getById(String id) {
		return users.get(id);
	}
	
	public Collection<User> getAllUsers(){
		return users.values();
	}
	
	public void save(User user) {
		users.put(user.getFirstName(), user);
	}
}
