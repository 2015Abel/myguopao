package org.feign.consumer.controller;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.feign.user.api.domain.User;
import org.feign.user.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignConsumerController {
	
	@Resource
	UserService userService;
	
	@PostMapping("/user/save")
	boolean save(@RequestBody User user){
		return userService.save(user);
	}
	
	@GetMapping("/user/findAll")
	Collection<User> findAll() throws Exception{
//		TimeUnit.SECONDS.sleep(1L);
		return userService.findAll();
	}
}
