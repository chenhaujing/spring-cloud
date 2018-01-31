package com.chj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulFallbackApplication {
    public static void main( String[] args ){
//        System.out.println( "Hello World!" );
        SpringApplication.run(ZuulFallbackApplication.class,args);
    }
}
