package com.chj.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chj.config.FeignConfiguration2;

/**
 * 
 * @author hankin
 *
 */
@FeignClient(name="xxx",url = "http://localhost:8761/", 
				configuration=FeignConfiguration2.class)
public interface UserFeignClientConfig2 {
	/**
	 * 通过配置 查找Eureka服务商注册的 其他微服务的信息
	 */
	 @RequestMapping(value = "/eureka/apps/{serviceName}")
	 public String findServiceFromEureka(@PathVariable("serviceName") String serviceName);
	
}
