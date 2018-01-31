package com.chj.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class RibbonPropertyApplication {

	@Bean
	@LoadBalanced	//ribbon注解
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonPropertyApplication.class, args);
	}
}
