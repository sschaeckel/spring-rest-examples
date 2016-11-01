package com.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.example.roles.Role;
import com.example.roles.RoleRepository;
import com.example.roles.RoleResource;
import com.example.roles.RoleResourceAssembler;

@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource>{

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleResourceAssembler roleResourceAssembler;

	public UserResourceAssembler() {
		super(UserController.class, UserResource.class);
	}

	@Override
	public UserResource toResource(User entity) {
		UserResource resource = createResourceWithId(entity.getId(), entity);
		RoleResource wrapped = wrappedRoleResource(entity);
		resource.setRole(wrapped);
		return resource;
	}

	@Override
	protected UserResource instantiateResource(User entity) {
		RoleResource wrapped = wrappedRoleResource(entity);
		UserResource userResource = new UserResource(entity, wrapped);
		
		return userResource;
	}
	
	private RoleResource wrappedRoleResource(User entity) {
		Role role = roleRepository.findByRole(entity.getRole());
		RoleResource wrapped = roleResourceAssembler.toResource(role);
		return wrapped;
	}

}
