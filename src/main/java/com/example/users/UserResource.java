package com.example.users;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.example.roles.RoleResource;

@Relation(value = "user", collectionRelation = "users")
public class UserResource extends ResourceSupport{

	private String firstName;
	private String lastName;
	private RoleResource role;

	public UserResource() {}
	
	public UserResource(User entity, RoleResource role) {
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.role = role;
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

	public RoleResource getRole() {
		return role;
	}
	
	public void setRole(RoleResource role) {
		this.role = role;
	}

}
