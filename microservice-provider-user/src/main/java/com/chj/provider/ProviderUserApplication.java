package com.chj.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class ProviderUserApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProviderUserApplication.class, args);
	}
}
