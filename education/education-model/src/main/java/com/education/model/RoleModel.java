package com.education.model;

import java.io.Serializable;

/**
 * 教师角色表实体类
 * 
 * @author FYM
 *
 */
public class RoleModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 权限编号
	 */
	private int roleId;
	/**
	 * 权限名称
	 */
	private String roleName;
	/**
	 * 等级说明
	 */
	private String roleDesc;
	/**
	 * 权限删除状态
	 */
	private int roleDelete;

	public int getRoleDelete() {
		return roleDelete;
	}

	public void setRoleDelete(int roleDelete) {
		this.roleDelete = roleDelete;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleModel [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", roleDelete="
				+ roleDelete + "]";
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
