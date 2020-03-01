package com.dushant.Resilience4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.dushant")
public class Resilience4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jApplication.class, args);
	}

}
