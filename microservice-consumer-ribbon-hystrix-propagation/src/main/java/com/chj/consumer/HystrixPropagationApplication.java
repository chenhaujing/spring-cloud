package com.chj.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixPropagationApplication {

	@Bean
	@LoadBalanced	//ribbon注解
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	
	public static void main(String[] args) {
//		SpringApplication.run(HystrixRibbonApplication.class, args);
		new SpringApplicationBuilder(HystrixPropagationApplication.class).web(true).run(args);
	}
}
