package com.chj.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chj.cloud.entrity.User;

/**
 * 
 * @author hankin
 *
 */
@FeignClient("microservice-provider-user")
public interface UserFeignClient {

	//两个坑：1. @GetMapping不支持，2.@PathVariable得设value值
	 @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	 public User findById(@PathVariable("id") String id);

	 @RequestMapping(method = RequestMethod.POST, value = "/user")
	 public User postUser(@RequestBody User user);
	 
	 /**
	  * feign的第三个坑：关于get请求传递对象的问题（如果是对象默认会当做post请求）
	  * 注意 如果需要用get方法传递多个参数，使用@RequestParam方式调用user微服务中的get方法
	  * @param user
	  * @return
	  */
	 @RequestMapping(method = RequestMethod.GET, value = "/get-user")
	 public User getUser(@RequestParam("id")String id, @RequestParam("name")String name);
//	 public User getUser(User user);
}
