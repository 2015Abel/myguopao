package org.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignProviderStarter {

	public static void main(String[] args) {
		SpringApplication.run(FeignProviderStarter.class, args);

	}

}
