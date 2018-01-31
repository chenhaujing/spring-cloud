package com.chj.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chj.cloud.entrity.User;
import com.chj.cloud.feign.UserFeignClient;

@RestController
public class MovieFeignController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/feign/{id}")
	public User findByUserId(@PathVariable String id) {
		return this.userFeignClient.findById(id);
	}
	
	/**
	 * 测试post方法调用user服务
	 * @param user
	 * @return
	 */
	@GetMapping("/post-user")
	public User postUser(User user) {
		return this.userFeignClient.postUser(user);
	}
	
	/**
	 * 测试get方法传递对象参数 调用user服务
	 * @param user
	 * @return
	 */
	@GetMapping("/get-user")
	public User getUser(User user) {
		return this.userFeignClient.getUser(user.getId(), user.getName());
	}
	
}
