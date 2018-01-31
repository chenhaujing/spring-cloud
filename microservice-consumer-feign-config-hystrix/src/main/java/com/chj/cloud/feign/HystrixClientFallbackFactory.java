package com.chj.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chj.cloud.entrity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements  FallbackFactory<FeignClientHystrix>  {

	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);
	@Override
	public FeignClientHystrix create(Throwable cause) {
		HystrixClientFallbackFactory.LOGGER.info("fallback; reason was: " + cause.getMessage());
		return new FeignClientHystrix() {
			@Override
			public User findById(String id) {
				User user  = new User();
				user.setId("1000");
				return user;
			}
		};
	}

}
