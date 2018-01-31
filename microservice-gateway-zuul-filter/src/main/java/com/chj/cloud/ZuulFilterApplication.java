package com.chj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.chj.cloud.filter.PreZuulFilter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFilterApplication {
    public static void main( String[] args ){
//        System.out.println( "Hello World!" );
        SpringApplication.run(ZuulFilterApplication.class,args);
    }
    
    @Bean
    public PreZuulFilter preZuulFilter () {
    	return new PreZuulFilter();
    }
}
