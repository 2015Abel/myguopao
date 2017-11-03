package org.user.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.user.service.config.RibbonConfig;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="user-service-provider",configuration=RibbonConfig.class)
public class UserServiceConsumerStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceConsumerStarter.class, args);
	}
	
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate(new HttpComponentsClientHttpRequestFactory());	//HttpClient实现
	}
}
