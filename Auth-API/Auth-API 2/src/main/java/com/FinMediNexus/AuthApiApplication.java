package com.FinMediNexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

	@SpringBootApplication
	//@ComponentScan(basePackages = {"com.Auth", "com.FinMediNexus"})
	public class AuthApiApplication {

		public static void main(String[] args) {
			SpringApplication.run(AuthApiApplication.class, args);
		}


}
