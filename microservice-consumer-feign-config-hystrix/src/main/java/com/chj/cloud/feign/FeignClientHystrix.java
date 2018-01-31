package com.chj.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.chj.cloud.entrity.User;

import feign.Param;
import feign.RequestLine;

/**
 * 
 * @author hankin
 *
 */
@FeignClient(name="microservice-provider-user",
fallbackFactory = HystrixClientFallbackFactory.class)
public interface FeignClientHystrix {

//	 @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
//	 public User findById(@PathVariable("id") String id);
	 
	 @RequestLine("GET /user/{id}")
	 public User findById(@Param("id") String id);

}
