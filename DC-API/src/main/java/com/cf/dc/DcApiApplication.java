package com.cf.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DcApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcApiApplication.class, args);
	}

}
