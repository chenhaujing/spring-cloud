package com.chj.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chj.consumer.entrity.User;

@RestController
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    private LoadBalancerClient loadBalancer;
	
	@GetMapping("/ribben/{id}")
	public User findByUserId(@PathVariable Long id) {
		//this.userServicePath+id = http://user:123456@localhost:8761/eureka
		//VIP virtual IP 通过microservice-provider-user来访问用户服务
		User user = this.restTemplate.getForObject("http://microservice-provider-user/user/"+id, User.class);
		System.out.println(user.getId()+":"+user.getName()+":"+user.getAddress());
		
		ServiceInstance instance = this.loadBalancer.choose("microservice-provider-user");
	    System.out.println("000=="+instance.getHost()+":"+instance.getPort()+":"+instance.getServiceId());
	    
		return user;
	}
	
	@GetMapping("/test")
	public String testRibbon() {
		ServiceInstance instance = this.loadBalancer.choose("microservice-provider-user");
	    System.out.println("111=="+instance.getHost()+":"+instance.getPort()+":"+instance.getServiceId());
		
	    ServiceInstance instance2 = this.loadBalancer.choose("microservice-provider-user2");
	    System.out.println("222=="+instance2.getHost()+":"+instance2.getPort()+":"+instance2.getServiceId());
	    
	    return "1";
	}
}
