package com.education.service;


import com.education.model.ResultDo;
import com.education.model.RoleModel;

/**
 * 角色业务处理层接口
 * @author 杨振欣
 *
 */
public interface IRoleService {
	/**
	 * 查询所有角色
	 * @return 	ResultDo<Object> 所有角色信息(统一返回值信息)
	 * @throws Exception 抛出数据层异常
	 */
	ResultDo<Object> listAllRole() throws Exception;

	/**
	 * 添加角色信息
	 * @param roleModel 角色实体
	 * @return 	ResultDo<Object> 影响的行数(统一返回值信息)
	 * @throws Exception 抛出数据层异常
	 */
	ResultDo<Object>  addRole(RoleModel roleModel) throws Exception;
	/**
	 * 修改角色信息
	 * @param roleModel 角色实体
	 * @return 	ResultDo<Object> 返回影响的行数(统一返回值信息)
	 * @throws Exception 抛出数据层异常
	 */
	ResultDo<Object>  updateRole(RoleModel roleModel)throws Exception;
	
	/**
	 * 根据编号删除角色信息
	 * @param roleId 权限编号
	 * @return 	ResultDo<Object> 返回影响的函数(统一返回值信息)
	 * @throws Exception 抛出数据层异常
	 */
	ResultDo<Object>  deleteRole(Integer roleId)throws Exception;
}
