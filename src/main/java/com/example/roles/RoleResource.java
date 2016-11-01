package com.example.roles;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Relation(value = "role", collectionRelation = "roles")
public class RoleResource extends ResourceSupport{

	private String role;
	private String description;
	
	public RoleResource(){}
	
	public RoleResource(Role entity) {
		this.role = entity.getRole();
		this.description = entity.getDescription();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RoleResource [role=" + role + ", description=" + description + "]";
	}
	
}
