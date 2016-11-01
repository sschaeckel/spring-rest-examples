package com.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(UserResource.class)
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	@Autowired
	private PagedResourcesAssembler<User> pagedResourcesAssembler;
	@Autowired
	private UserResourceAssembler userResourceAssembler;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PagedResources<UserResource>> users(
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "2") Integer size) {
		PageRequest pageable = new PageRequest(page, size);
		Page<User> users = repository.findAll(pageable);
		PagedResources<UserResource> resource = pagedResourcesAssembler.toResource(users, userResourceAssembler);
		return ResponseEntity.ok(resource);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<UserResource> oneUse(@PathVariable Long id){
		User user = repository.findOne(id);
		UserResource resource = userResourceAssembler.toResource(user);
		return ResponseEntity.ok(resource);
	}
}
