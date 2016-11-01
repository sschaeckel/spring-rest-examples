package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.roles.Role;
import com.example.roles.RoleRepository;
import com.example.users.User;
import com.example.users.UserRepository;

@ConditionalOnProperty("loadsampledata")
@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		roleRepository.save(new Role("ADMIN", "Adminstrator"));
		roleRepository.save(new Role("USER", "User"));
		
		userRepository.save(new User("user1", "name1", "ADMIN"));
		userRepository.save(new User("user2", "name2", "USER"));
		userRepository.save(new User("user3", "name3", "USER"));
		userRepository.save(new User("user4", "name4", "USER"));
		userRepository.save(new User("user5", "name5", "ADMIN"));
		userRepository.save(new User("user6", "name6", "ADMIN"));
		userRepository.save(new User("user7", "name7", "USER"));
		userRepository.save(new User("user8", "name8", "USER"));
		userRepository.save(new User("user9", "name9", "USER"));
	}

}
