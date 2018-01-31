package com.chj.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chj.cloud.entrity.User;

/**
 * 
 * @author hankin
 *
 */
@FeignClient(name = "microservice-provider-user", fallback = HystrixClientFallback.class)
//@FeignClient(name = "hello", fallbackFactory = HystrixClientFallbackFactory.class)
public interface FeignHystrixClient {

	//两个坑：1. @GetMapping不支持，2.@PathVariable得设value值
	 @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	 public User findById(@PathVariable("id") String id);
}
