package com.milind.user.service.services;

import java.util.List;

import com.milind.user.service.entities.User;

public interface UserService {
	
	// user operations
	
	// create
	User saveuser(User user);
	
	// get all user
	List<User> getAllUser();
	
	// get single user of given userId
	User getUser(String UserID);
	
	// update
	
	// delete
	
}
