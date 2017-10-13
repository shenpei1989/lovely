package com.lovely.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lovely.user.entity.User;
import com.lovely.user.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public Iterable<User> all1(){
		return userService.findAll();
	}
	
	@PostMapping(path="add")
	public User add(@RequestBody User user){
		return userService.save(user);
	}
	
	@GetMapping(path="delete/{id}")
	public String delete(@PathVariable("id") long id){
		userService.delete(userService.find(id));
		return "deleted";
	}
	
	@GetMapping(path="/find/{id}")
	public User fingOneById(@PathVariable("id") long id){
		return userService.find(id);
	}
	
	@PostMapping(path="edit/{id}")
	public User update(@RequestBody User user){
		return userService.update(user);
	}
	
}
