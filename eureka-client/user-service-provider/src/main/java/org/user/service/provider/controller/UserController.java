/**
 * 
 */
package org.user.service.provider.controller;

import java.util.Collection;

import javax.annotation.Resource;

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
	
	@Resource
	UserService userServiceImpl;
	
	@PostMapping("/user/save")
	public User addUser(@RequestParam String name){
		System.out.println(">>>>>>>>>>>>>Provider Server1 method");
		User user = new User();
		user.setName(name);
		if(userServiceImpl.addUser(user)){
			return user;
		}else{
			return null;
		}
	}
	
	@GetMapping("/user/list")
	public Collection<User> getUsers(){
		System.out.println(">>>>>>>>>>>>>Provider Server1 method");
		return userServiceImpl.findAll();
	}
}
