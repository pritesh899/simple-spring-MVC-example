package com.pritesh.us.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pritesh.us.api.exception.BadRequestException;
import com.pritesh.us.api.respository.Respository;
import com.pritesh.us.api.service.UserService;
import com.pritesh.us.api.user.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private Respository respository;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return respository.findAll();
	}
	
	@Transactional(readOnly=true)
	@Override
	public User findOne(String id) {
		
		User existing = respository.findOne(id);
		if(existing == null)
		{
			//throw new NotFoundException("User with "+id+" does not exist");
			throw new BadRequestException("User with "+id+" does not exist");
		}
		return existing;
		
	}

	@Override
	@Transactional
	public User createUser(User user) {
		User existing = respository.findEmail(user.getEmail());
		if(existing != null)
		{
			throw new BadRequestException("User with "+user.getEmail()+" does not exist");
		}
		return respository.createUser(user);
	}

	@Override
	@Transactional
	public User updateUser(String id, User user) {
		User existing = respository.findOne(id);
		if(existing == null)
		{
			//throw new NotFoundException("User with "+id+" does not exist");
			throw new BadRequestException("User with "+id+" does not exist");
		}
		return respository.updateUser( user);
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		User existing = respository.findOne(id);
		if(existing == null)
		{
			//throw new NotFoundExceptionE("User with "+id+" does not exist");
			throw new BadRequestException("User with "+id+" does not exist");
		}
		respository.deleteUser(existing);
	}

}
