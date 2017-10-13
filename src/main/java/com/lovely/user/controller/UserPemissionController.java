package com.lovely.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovely.user.entity.UserPermission;
import com.lovely.user.services.UserPermissionService;

import antlr.collections.List;

@RestController
@RequestMapping("/api/permission")
public class UserPemissionController {
	@Autowired
	UserPermissionService userPermissionService;
	
	@RequestMapping("")
	public Iterable<UserPermission> findAll(){
		return userPermissionService.findAll();
	}
	
	@PostMapping("add")
	public UserPermission add(@RequestBody UserPermission userPermission){
		return userPermissionService.save(userPermission);
	}
	
	@PostMapping("edit/{id}")
	public UserPermission update(@RequestBody UserPermission userPermission){
		return userPermissionService.update(userPermission);
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") long id){
		userPermissionService.delete(id);
		return "deleted";
	}
}
