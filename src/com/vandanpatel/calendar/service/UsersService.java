package com.vandanpatel.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;


import com.vandanpatel.calendar.dao.UserDAO;
import com.vandanpatel.calendar.model.User;

@Service("usersService")
public class UsersService {

	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void create(User user){
		userDAO.create(user);
	}

	public boolean exists(String username) {
		return userDAO.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		
		return userDAO.getAllUsers();
	}

	public User getUser(int sanitized_id) {
		
		return userDAO.getUser(sanitized_id);
	}

	public boolean update(User user) {
		
		return userDAO.update(user);
	}

	public boolean deleteUser(int sanitized_id) {
		
		return userDAO.delete(sanitized_id);
	}

}
