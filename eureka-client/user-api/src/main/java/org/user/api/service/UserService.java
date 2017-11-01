package org.user.api.service;

import java.util.Collection;

import org.user.api.entity.User;

/**
 * @ClassName: UserService
 * @Description: 用户服务
 * @author: liuzijian
 * @date: 2017年10月30日 下午5:54:22
 */
public interface UserService {
	/**
	 * @Title: addUser
	 * @Description: 如果保存成功，返回 <code>true</code>；否则，返回<code>false</code>
	 * @author: liuzijian
	 * @date: 2017年10月30日 下午6:01:54
	 * @return: boolean
	 */
	boolean addUser(User user);
	
	/**
	 * @Title: findAll
	 * @Description: 查找全部用户，不会返回null
	 * @author: liuzijian
	 * @date: 2017年10月30日 下午5:55:32
	 * @return: Collection<User>
	 */
	Collection<User> findAll();
}
