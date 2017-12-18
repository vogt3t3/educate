package com.education.dao;

import java.util.List;

import com.education.model.RoleModel;

/**
 * 角色数据层接口
 * 
 * @author 杨振欣
 *
 */
public interface RoleDao {
	/**
	 * 查询所有角色
	 * 
	 * @return List<RoleModel> 所有角色信息
	 * @throws Exception 抛出数据层异常
	 */
	List<RoleModel> listAllRole() throws Exception;

	/**
	 * @param roleModel 角色实体
	 * @return Integer 影响的行数
	 * @throws Exception 抛出数据层异常
	 */
	Integer addRole(RoleModel roleModel) throws Exception;
	/**
	 * @param roleModel 角色实体
	 * @return Integer 返回影响的行数
	 * @throws Exception 抛出数据层异常
	 */
	Integer updateRole(RoleModel roleModel)throws Exception;
	
	/**
	 * @param roleId 权限编号
	 * @return Integer 返回影响的函数
	 * @throws Exception 抛出数据层异常
	 */
	Integer deleteRole(Integer roleId)throws Exception;
}
