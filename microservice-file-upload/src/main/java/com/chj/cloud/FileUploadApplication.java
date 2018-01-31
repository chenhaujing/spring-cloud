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
public class FileUploadApplication {
    public static void main( String[] args ){
//        System.out.println( "Hello World!" );
        SpringApplication.run(FileUploadApplication.class,args);
    }
}
