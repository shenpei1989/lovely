package com.lovely.user.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lovely.user.entity.UserPermission;

public interface UserPermissionRepository extends CrudRepository<UserPermission, Integer>{
	public UserPermission findByPermissionName(String name);
	
	@Transactional
	@Query(value="delete from UserPermission where permissionId=?1 or parentId=?1")
	@Modifying
	public void deleteByPermissionIdOrParentId(long id);
}
