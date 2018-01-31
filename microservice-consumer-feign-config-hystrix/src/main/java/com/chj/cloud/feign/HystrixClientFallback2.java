package com.chj.cloud.feign;

import org.springframework.stereotype.Component;


@Component
public class HystrixClientFallback2 implements FeignConfigHystrixClient2 {

	@Override
	public String findServiceFromEureka(String serviceName) {
	
		return "test no server message!!";
	}


}
