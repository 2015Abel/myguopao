package org.feign;

import org.feign.consumer.controller.config.FirstServerIRule;
import org.feign.user.api.impl.UserServiceFallbackImpl;
import org.feign.user.api.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients(clients=UserService.class)
@RibbonClient(value="user-service",configuration=FeignConsumerStarter.class)
@EnableCircuitBreaker
public class FeignConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(FeignConsumerStarter.class, args);
	}
	
	@Bean
	public FirstServerIRule getIRule(){
		return new FirstServerIRule();
	}
	
	@Bean
	public UserServiceFallbackImpl getFallbackBean(){
		return new UserServiceFallbackImpl();
	}
	
}
