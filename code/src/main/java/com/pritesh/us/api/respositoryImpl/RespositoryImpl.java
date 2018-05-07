package com.pritesh.us.api.respositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pritesh.us.api.respository.Respository;
import com.pritesh.us.api.user.User;

@Repository
public class RespositoryImpl implements Respository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		
		return em.find(User.class, id);
	}

	@Override
	public User findEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		
		if(!users.isEmpty())
		{
			return users.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return em.merge(user);
	}

	@Override
	public void deleteUser(User user) {
		em.remove(user);
	}

	

}
