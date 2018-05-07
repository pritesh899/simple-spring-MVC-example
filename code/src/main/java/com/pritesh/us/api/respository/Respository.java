package com.pritesh.us.api.respository;

import java.util.List;

import com.pritesh.us.api.user.User;

public interface Respository {

		public List<User> findAll();
		
		public User findOne(String id);
		
		public User findEmail(String email);
		
		public User createUser( User user);
		
		public User updateUser(User user);
		
		public void deleteUser(User user);
}
