package com.lovely.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.lovely.user.entity.User;
import com.lovely.user.services.UserService;

@Controller
@RequestMapping("user")
public class DemoController {
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap){
		modelMap.put("user", userService.findAll());
		return "user/info";
	}
	
	@GetMapping(path="/add")
	public String add(ModelMap modelMap){
		modelMap.put("user", new User());
		return "user/add";
	}
	
	@PostMapping(path="add")
	public String add(@ModelAttribute("user") User user){
		userService.save(user);
		return "redirect:/user";
	}
	
	@GetMapping(path="delete/{id}")
	public String delete(@PathVariable("id") long id){
		userService.delete(userService.find(id));
		return "redirect:/user";
	}
	
	@GetMapping(path="edit/{id}")
	public String edit(@PathVariable("id") long id, ModelMap modelMap){
		modelMap.put("user",userService.find(id));
		return "user/edit";
	}
	
	@PostMapping(path="edit")
	public String edit(@ModelAttribute("user") User user){
		User user2=userService.find(user.getId());
		user2.setUsername(user.getUsername());
		user2.setPassword(user.getPassword());
		user2.setCreateTime(user.getCreateTime());
		userService.update(user2);
		return "redirect:/user";
	}
	
}
