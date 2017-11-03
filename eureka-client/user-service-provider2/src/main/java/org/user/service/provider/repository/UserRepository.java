package org.user.service.provider.repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;
import org.user.api.entity.User;

@Repository
public class UserRepository {
	
	Map<Long,User> dbMap = new ConcurrentHashMap<>();
	AtomicLong idGenerator = new AtomicLong();
	
	public Collection<User> findAll() {
        return dbMap.values();
    }

    public boolean save(User user) {
        Long id = idGenerator.incrementAndGet();
        user.setId(id);
        return dbMap.putIfAbsent(id, user) == null;
    }
}
