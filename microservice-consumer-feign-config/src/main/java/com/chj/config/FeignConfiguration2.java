package com.chj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration2 {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "123456");
    }
    
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
