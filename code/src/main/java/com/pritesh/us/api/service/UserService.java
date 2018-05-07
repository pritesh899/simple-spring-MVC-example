package com.pritesh.us.api.service;

import java.util.List;

import com.pritesh.us.api.user.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findOne(String id) ;
	
	public User createUser( User user) ;
	
	public User updateUser(String id, User user) ;
	
	public void deleteUser(String id);
}
