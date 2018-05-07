package com.pritesh.us.api.user;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "User.findAll", query="SELECT e FROM User e ORDER BY e.firstName"),
	@NamedQuery(name = "User.findByEmail", query="SELECT e FROM User e where e.email=:pEmail")
})

public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String email;
	
	public User()
	{
		this.id = UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
