package com.lovely.main.dao;

import org.springframework.data.repository.CrudRepository;

import com.lovely.main.entity.User;

public interface UserDAO extends CrudRepository<User, Long>{
	
}
