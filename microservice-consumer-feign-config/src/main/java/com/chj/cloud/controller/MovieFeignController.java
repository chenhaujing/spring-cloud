package com.chj.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chj.cloud.entrity.User;
import com.chj.cloud.feign.UserFeignClientConfig;
import com.chj.cloud.feign.UserFeignClientConfig2;

@RestController
public class MovieFeignController {
	
	@Autowired
	private UserFeignClientConfig userFeignClientConfig;
	
	@Autowired
	private UserFeignClientConfig2 userFeignClientConfig2;
	
	/**
	 * 通过自定义配置方式访问用户微服务
	 */
	@GetMapping("/user/{id}")
	public User findByUserId(@PathVariable String id) {
		return this.userFeignClientConfig.findById(id);
	}
	
	/**
	 * 访问Eureka server上面注册的微服务信息
	 */
	@GetMapping("/{serviceName}")
	public String findServiceFromEureka(@PathVariable String serviceName) {
		return this.userFeignClientConfig2.findServiceFromEureka(serviceName);
	}
	
}
