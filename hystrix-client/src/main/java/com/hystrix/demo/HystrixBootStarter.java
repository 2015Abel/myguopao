package com.hystrix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
public class HystrixBootStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixBootStarter.class, args);
	}
}
