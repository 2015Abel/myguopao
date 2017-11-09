package org.feign.user.api.service;

import java.util.Collection;

import org.feign.user.api.domain.User;
import org.feign.user.api.impl.UserServiceFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@FeignClient(value="user-service",fallback=UserServiceFallbackImpl.class)
public interface UserService {
	
	/**
	 * @Title: save
	 * @Description: 如果成功，返回<code>true</code>
	 * @author: liuzijian
	 * @date: 2017年11月8日 上午9:48:14
	 * @param {@link User}
	 * @return: boolean
	 */
	@PostMapping("/user/save")
	boolean save(@RequestBody User user);
	
	/**
	 * @Title: findAll
	 * @Description: 不会返回null
	 * @author: liuzijian
	 * @date: 2017年11月8日 上午9:52:02
	 * @return: Collection<User>
	 */
	@GetMapping("/user/findAll")
	@HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "1")
            })
	Collection<User> findAll();
}
