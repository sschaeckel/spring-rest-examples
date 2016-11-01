package com.example.users;

import org.springframework.hateoas.ResourceSupport;

public class UserResource extends ResourceSupport{

	private String firstName;
	private String lastName;

	public UserResource() {}
	
	public UserResource(User entity) {
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
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

}
