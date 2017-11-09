package org.feign.provider.controller;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.feign.user.api.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class FeignProviderController {
	
	private final static Map<Long,User> repository = new ConcurrentHashMap<>();
	
	@PostMapping("/user/save")
	public boolean save(@RequestBody User user){
		return repository.put(user.getId(), user)==null;
	}
	
	@GetMapping("/user/findAll")
	@HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "1")
            })
	public Collection<User> findAll() throws Exception{
//		TimeUnit.SECONDS.sleep(1L);
		return repository.values();
	}
}
