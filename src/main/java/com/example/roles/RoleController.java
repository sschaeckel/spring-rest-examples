package com.example.roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(RoleResource.class)
@RequestMapping(value = "/roles")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleResourceAssembler roleResourceAssembler;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RoleResource>> roles(){
		List<Role> roles = roleRepository.findAll();
		List<RoleResource> resources = roleResourceAssembler.toResources(roles);
		return ResponseEntity.ok(resources);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<RoleResource> roleById(@PathVariable Long id){
		Role role = roleRepository.findOne(id);
		RoleResource resource = roleResourceAssembler.toResource(role);
		return ResponseEntity.ok(resource);
	}

}
