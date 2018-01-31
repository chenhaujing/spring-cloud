package com.chj.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chj.provider.entity.User;
import com.chj.provider.repository.UserPepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;


@RestController
public class UserController {
	
	@Autowired
	private UserPepository userPository;
	
	@Autowired
	private EurekaClient discoveryClient;
	
	//@RequestMapping(method = RequestMethod.GET,value="xxx")
	@GetMapping("/user/{id}")
	public User findById(@PathVariable String id) {
		return this.userPository.findOne(id);
		
	}
	
	/**
	 * 获取虚拟主机的地址
	 * @return
	 */
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		System.out.println("7900 use service!");
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	}
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user) {
		return user;
	}
	
	@GetMapping("/get-user")
	public User getUser(User user) {
		return user;
	}
	
	//使用RestTemplate时，想要获得一个List时，应该用数组，而不应该直接用List
	@GetMapping("/all")
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		User user = new User("2001","saaa", "0000", null);
		User user2 = new User("2002","bbbb", "1111", null);
		User user3 = new User("2003","ccc", "2222", null);
		userList.add(user);
		userList.add(user2);
		userList.add(user3);
		return userList;
	}
	

}
