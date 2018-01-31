package com.chj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main( String[] args ){
//        System.out.println( "Hello World!" );
        SpringApplication.run(EurekaApplication.class,args);
    }
}
