package com.lovely.user.services;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lovely.user.dao.UserPermissionRepository;
import com.lovely.user.entity.UserPermission;

@Service
@Transactional
public class UserPermissionService {
	@Autowired
	UserPermissionRepository userPermissionDAO;
	
	public Iterable<UserPermission> findAll(){
		return userPermissionDAO.findAll();
	}
	
	public UserPermission find(int id){
		return userPermissionDAO.findOne(id);
	}
	
	public UserPermission save(UserPermission userPermission){
		userPermission.setCreateTime(new Timestamp(System.currentTimeMillis()));
		userPermission.setUpdateTime(userPermission.getCreateTime());
		return userPermissionDAO.save(userPermission);
	}
	
	public UserPermission update(UserPermission userPermission){
		userPermission.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		return userPermissionDAO.save(userPermission);
	}
	
	public void delete(long id){
		userPermissionDAO.deleteByPermissionIdOrParentId(id);
	}
	
	public UserPermission findByPermissionName(String permissionName){
		return userPermissionDAO.findByPermissionName(permissionName);
	}
}
