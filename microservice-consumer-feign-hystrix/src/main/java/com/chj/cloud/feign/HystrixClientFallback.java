package com.chj.cloud.feign;

import org.springframework.stereotype.Component;

import com.chj.cloud.entrity.User;

@Component
public class HystrixClientFallback implements FeignHystrixClient {

	@Override
	public User findById(String id) {
		User user  = new User();
		user.setId("1001");
		return user;
	}


}
