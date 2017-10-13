package com.lovely.user.services;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovely.user.dao.UserRepository;
import com.lovely.user.entity.User;

@Service("userService")
@Transactional
public class UserService {
	@Autowired
	private  UserRepository userDAO;
	
	public Iterable<User> findAll(){
		return userDAO.findAll();
	}
	
	public User find(Long id){
		return userDAO.findOne(id);
	}
	
	public User save(User user){
		user.setCreateTime(new Timestamp(System.currentTimeMillis()));
		user.setUpdateTime(user.getCreateTime());
		return userDAO.save(user);
	}
	
	public User update(User user){
		user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return userDAO.save(user);
	}
	
	public void delete(User user){
		userDAO.delete(user);
	}
	
	public User findByUserName(String username){
		return userDAO.findByUsername(username);
	}
}
