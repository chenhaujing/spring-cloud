package com.chj.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.chj.config.TestConfiguration;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)
//ribbon自定义配置放在启动文件同一级目录情况下使用改配置
//@ComponentScan(excludeFilters= {@ComponentScan.Filter(type=FilterType.ANNOTATION, value=TestExclude.class)})
public class RibbonApplication {

	@Bean
	@LoadBalanced	//ribbon注解
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
