package com.lovely.user.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_permission")
public class UserPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long permissionId;
	private String permissionName;
	private String permissionCode;
	private long parentId;
	private int permissionType;
	// 权限状态  false禁用 true可用,默认可用
	private boolean permissionState=true;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	@ManyToMany
	@JoinTable(name="role_permission",joinColumns={@JoinColumn(name="permission_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
	private Set<UserRole> roleSet;

	public long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public int getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(int permissionType) {
		this.permissionType = permissionType;
	}

	public boolean isPermissionState() {
		return permissionState;
	}

	public void setPermissionState(boolean permissionState) {
		this.permissionState = permissionState;
	}

	public Set<UserRole> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<UserRole> roleSet) {
		this.roleSet = roleSet;
	}
}
