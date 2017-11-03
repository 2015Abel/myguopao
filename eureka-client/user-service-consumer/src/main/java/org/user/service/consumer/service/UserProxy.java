/**
 * 
 */
package org.user.service.consumer.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.user.api.entity.User;
import org.user.api.service.UserService;

/**
 * @ClassName: UserProxy
 * @Description: TODO
 * @author: liuzijian
 * @date: 2017年10月31日 下午11:13:26
 */
@Service("userProxy")
public class UserProxy implements UserService {
	
	 private static final String PROVIDER_SERVER_URL_PREFIX = "http://user-service-provider";

	    /**
	     * 通过 REST API 代理到服务器提供者
	     */
	    @Autowired
	    private RestTemplate restTemplate;

	    @Override
	    public boolean addUser(User user) {
	        User returnValue =
	                restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX+"/user/save?name={name}", null, User.class,user.getName());
	        return returnValue != null;
	    }

	    @Override
	    public Collection<User> findAll() {
	        return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "/user/list", Collection.class);
	    }

}
