package com.lovely.main.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovely.main.dao.UserDAO;
import com.lovely.main.entity.User;

@Service("userService")
@Transactional
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public Iterable<User> findAll(){
		return userDAO.findAll();
	}
	
	public User find(Long id){
		return userDAO.findOne(id);
	}
	
	public void save(User user){
		userDAO.save(user);
	}
	
	public void delete(User user){
		userDAO.delete(user);
	}
}
