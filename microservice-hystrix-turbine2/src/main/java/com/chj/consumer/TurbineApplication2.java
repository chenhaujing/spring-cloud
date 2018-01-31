package com.chj.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


@SpringBootApplication
@EnableTurbine
public class TurbineApplication2 {
	
	public static void main(String[] args) {
//		SpringApplication.run(HystrixRibbonApplication.class, args);
		new SpringApplicationBuilder(TurbineApplication2.class).web(true).run(args);
	}
}
