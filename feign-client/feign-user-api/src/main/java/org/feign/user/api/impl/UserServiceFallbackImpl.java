package org.feign.user.api.impl;

import java.util.Collection;
import java.util.Collections;

import org.feign.user.api.domain.User;
import org.feign.user.api.service.UserService;
import org.springframework.stereotype.Component;

public class UserServiceFallbackImpl implements UserService {

	@Override
	public boolean save(User user) {
		return false;
	}

	@Override
	public Collection<User> findAll() {
		return Collections.emptyList();
	}

}
