package com.lovely.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.lovely.user.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUsername(String username);
}
