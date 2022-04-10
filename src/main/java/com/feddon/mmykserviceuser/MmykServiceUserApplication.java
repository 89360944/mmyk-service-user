package com.feddon.mmykserviceuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MmykServiceUserApplication {

    public static void main(String[] args) {
        System.out.println("hello MmykServiceUserApplication1");
        SpringApplication.run(MmykServiceUserApplication.class, args);
    }

}
