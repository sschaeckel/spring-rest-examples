package com.example.users;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource>{

	public UserResourceAssembler() {
		super(UserController.class, UserResource.class);
	}

	@Override
	public UserResource toResource(User entity) {
		UserResource resource = createResourceWithId(entity.getId(), entity);
		return resource;
	}

	@Override
	protected UserResource instantiateResource(User entity) {
		return new UserResource(entity);
	}
}
