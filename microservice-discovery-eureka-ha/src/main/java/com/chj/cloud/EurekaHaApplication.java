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
public class EurekaHaApplication {
    public static void main( String[] args ){
//        System.out.println( "Hello World!" );
        SpringApplication.run(EurekaHaApplication.class,args);
    }
}
