package com.example.roles;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class RoleResourceAssembler extends ResourceAssemblerSupport<Role, RoleResource>{

	public RoleResourceAssembler() {
		super(RoleController.class, RoleResource.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RoleResource toResource(Role entity) {
		RoleResource resource = createResourceWithId(entity.getId(), entity);
		return resource;
	}

	@Override
	protected RoleResource instantiateResource(Role entity) {
		return new RoleResource(entity);
	}
}
