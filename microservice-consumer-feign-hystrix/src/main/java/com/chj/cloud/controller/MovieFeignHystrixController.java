package com.chj.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chj.cloud.entrity.User;
import com.chj.cloud.feign.FeignHystrixClient;

@RestController
public class MovieFeignHystrixController {
	
	@Autowired
	private FeignHystrixClient feignHystrixClient;
	
	
	@GetMapping("/feign/{id}")
	public User getByUserId(@PathVariable String id) {
		return this.feignHystrixClient.findById(id);
	}

}
