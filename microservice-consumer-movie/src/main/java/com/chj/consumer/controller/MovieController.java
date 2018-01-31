package com.chj.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chj.consumer.entrity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user.userServicePath}")
	private String userServicePath;
	
	@GetMapping("/movie/{id}")
	public User findByUserId(@PathVariable Long id) {
		
		User user = this.restTemplate.getForObject(this.userServicePath+id, User.class);
		return user;
		
	}
	
}
