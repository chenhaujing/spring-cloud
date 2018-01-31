package com.chj.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chj.consumer.entrity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixRibbonController {

	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 熔断机制：如果被访问的微服务挂了或者出现异常，则通过fallback方法来返回一个默认值
	 * 使用commandProperties可以使findByUserId与@HystrixCommand保持同一个线程
	 */
	@GetMapping("/user/{id}")
	@HystrixCommand(fallbackMethod = "defaultFallback")
//    commandProperties = {
//      @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
//    })
	public User findByUserId(@PathVariable String id) {
		//VIP virtual IP 通过microservice-provider-user来访问用户服务
		User user = this.restTemplate.getForObject("http://microservice-provider-user/user/"+id, User.class);
		return user;
	}

    public User defaultFallback(String id) {
    	User user  = new User();
    	user.setId("0000");
        return user;
    }

	
}
