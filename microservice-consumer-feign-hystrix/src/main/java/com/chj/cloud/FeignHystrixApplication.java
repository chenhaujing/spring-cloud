package com.chj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //引入Feign注解
public class FeignHystrixApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FeignHystrixApplication.class, args);
	}
}
