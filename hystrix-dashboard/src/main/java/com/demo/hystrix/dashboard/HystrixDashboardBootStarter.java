package com.demo.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardBootStarter {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardBootStarter.class, args);
	}
}
