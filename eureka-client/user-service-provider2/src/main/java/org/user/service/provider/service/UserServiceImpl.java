package org.user.service.provider.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.user.api.entity.User;
import org.user.api.service.UserService;
import org.user.service.provider.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserRepository userRepository;

	@Override
	public boolean addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

}
