/**
 * 
 */
package org.user.service.consumer.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.user.api.entity.User;
import org.user.api.service.UserService;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author: liuzijian
 * @date: 2017年10月31日 下午10:53:54
 */
@RestController
public class UserController {
	
	@Resource(name="userProxy")
	UserService userService;
	
	@Autowired
    DiscoveryClient discoveryClient;
	
	@GetMapping("/dc")
	public String dc(){
		String services = discoveryClient.getServices().toString();
		return services;
	}
	
	@PostMapping("/user/addUser")
	public User addUser(@RequestParam String name){
		User user = new User();
		user.setName(name);
		if(userService.addUser(user)){
			return user;
		}else{
			return null;
		}
	}
	
	@GetMapping("/user/getUsers")
	public Collection<User> getUsers(){
		return userService.findAll();
	}
}
