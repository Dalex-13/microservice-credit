package com.nttdata.microservicecredit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceCreditApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCreditApplication.class, args);
    }

}
