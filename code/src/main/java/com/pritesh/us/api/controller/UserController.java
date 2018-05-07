package com.pritesh.us.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pritesh.us.api.service.UserService;
import com.pritesh.us.api.user.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags="Users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ApiOperation(value = "Find all users", notes = "Return all users from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public List<User> findAll()
	{
		return userService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	@ApiOperation(value = "Find one user", notes = "Return one user from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public User findOne(@PathVariable("id") String id)
	{
		return userService.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	@ApiOperation(value = "create new user", notes = "creating user in database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 400, message = "bad request"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public User createUser( @RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	@ApiOperation(value = "update user info", notes = "updating users in database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public User updateUser(@PathVariable("id") String id, @RequestBody User user) 
	{
		return userService.updateUser(id, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	@ApiOperation(value = "delete existing user", notes = "deleting user from database")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "success"),
			@ApiResponse(code = 404, message = "not found"),
			@ApiResponse(code = 500, message = "internal server error")
	})
	public void deleteUser(@PathVariable("id") String id)
	{
		userService.deleteUser(id);
	}
	
	
}
