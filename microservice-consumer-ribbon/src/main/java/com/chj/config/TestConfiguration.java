package com.chj.config;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;

@Configuration
public class TestConfiguration {
	@Autowired
	IClientConfig config;
	@Bean
	public Random ribbonPing(IClientConfig config) {
		 System.out.println("ribbon client TestConfiguration!"+new PingUrl());
//	     return new PingUrl();
	     return new Random();
	}
}
