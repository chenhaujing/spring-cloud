package com.chj.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.chj.cloud.entrity.User;
import com.chj.config.FeignConfiguration;

import feign.Param;
import feign.RequestLine;

/**
 * 
 * @author hankin
 *
 */
@FeignClient(name="microservice-provider-user",configuration=FeignConfiguration.class)
public interface UserFeignClientConfig {

//	 @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	 @RequestLine("GET /user/{id}")
	 public User findById(@Param("id") String id);

}
