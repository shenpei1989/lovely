package com.lovely.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovely.user.dao.RolePermissionRepository;
import com.lovely.user.dao.UserRoleRepository;

@Service
public class UserRoleService {
	@Autowired
	UserRoleRepository roleDAO;
	@Autowired
	RolePermissionRepository rolePermissionDAO;
	
	public  void getAll(){
		
	}
	
}
