package com.chj.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chj.cloud.entrity.User;
import com.chj.cloud.feign.FeignClientHystrix;
import com.chj.cloud.feign.FeignConfigHystrixClient;
import com.chj.cloud.feign.FeignConfigHystrixClient2;

@RestController
public class MovieFeignController {
	
	@Autowired
	private FeignConfigHystrixClient feignConfigHystrixClient;
	
	@Autowired
	private FeignConfigHystrixClient2 feignConfigHystrixClient2;
	
	@Autowired
	private FeignClientHystrix feignClientHystrix;
	
	/**
	 * 通过自定义配置方式访问用户微服务
	 */
	@GetMapping("/user/{id}")
	public User findByUserId(@PathVariable String id) {
		return this.feignConfigHystrixClient.findById(id);
	}
	
	/**
	 * 访问Eureka server上面注册的微服务信息
	 */
	@GetMapping("/{serviceName}")
	public String findServiceFromEureka(@PathVariable String serviceName) {
		return this.feignConfigHystrixClient2.findServiceFromEureka(serviceName);
	}
	
	/**
	 * 测试 Feign 支持Hystrix的 fallbackFactory 方法
	 * @param id
	 * @return
	 */
	@GetMapping("/userfactory/{id}")
	public User findByUserIdWithFallbackFactory(@PathVariable String id) {
		return this.feignClientHystrix.findById(id);
	}
}
