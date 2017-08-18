package com.lovely.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lovely.main.entity.User;
import com.lovely.main.services.UserService;

@RestController
public class DemoController {
	@Autowired
	private UserService userService;
	@GetMapping("/greeting/{userid}")
	public User greeting(@PathVariable("userid") long id){
		User user=userService.find(id);
		return user;
	}
}
