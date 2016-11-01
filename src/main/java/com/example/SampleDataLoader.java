package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.users.User;
import com.example.users.UserRepository;

@ConditionalOnProperty("loadsampledata")
@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		userRepository.save(new User("user1", "name1"));
		userRepository.save(new User("user2", "name2"));
		userRepository.save(new User("user3", "name3"));
		userRepository.save(new User("user4", "name4"));
		userRepository.save(new User("user5", "name5"));
		userRepository.save(new User("user6", "name6"));
		userRepository.save(new User("user7", "name7"));
		userRepository.save(new User("user8", "name8"));
		userRepository.save(new User("user9", "name9"));
	}

}
