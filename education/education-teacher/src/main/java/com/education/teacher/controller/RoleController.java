package com.education.teacher.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.RoleModel;
import com.education.service.IRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 角色管理控制层
 * @author 杨振欣
 *
 */
@Api(value = "/api/super/roleManager", description = "角色管理的相关操作")
@RestController
@RequestMapping("/api/super/roleManager")
public class RoleController {
	/**
	 * 注入角色管理接口
	 */
	@Reference
	private IRoleService roleService;
	
	

	/**
	 * 查询所有角色信息
	 * @return ResultDo<Object> 包含所有角色列表的统一返回值数据
	 * @throws Exception 抛出异常给全局异常处理
	 */
	@ApiOperation(notes = "getAllRole", httpMethod = "POST", value = "获取所有的角色信息")
	@RequestMapping(value="/getAllRole",method=RequestMethod.POST)
	public ResultDo<Object> listAllRole(@RequestBody Object obj) throws Exception{
		ResultDo<Object> rs=roleService.listAllRole();
		return rs;
		
	}
	/**
	 * 添加新的角色
	 * @param roleModel 角色信息实体
	 * @return ResultDo<Object>  包含添加状态的统一返回值类型
	 * @throws Exception 抛出异常给全局异常处理
	 */
	@ApiOperation(notes = "addNewRole", httpMethod = "POST", value = "添加角色实体")
	@RequestMapping(value="/addNewRole",method=RequestMethod.POST)
	public ResultDo<Object> addRole(@RequestBody RoleModel roleModel) throws Exception{
		return roleService.addRole(roleModel);
		
	}
	/**
	 * 修改角色
	 * @param roleModel 角色信息实体
	 * @return ResultDo<Object>  包含修改状态的统一返回值类型
	 * @throws Exception 抛出异常给全局异常处理
	 */
	@ApiOperation(notes = "updateRoleById", httpMethod = "POST", value = "根据编号修改实体")
	@RequestMapping(value="/updateRoleById",method=RequestMethod.POST)
	public ResultDo<Object> updateRole(@RequestBody RoleModel roleModel) throws Exception{
		return roleService.updateRole(roleModel);
	}

	/**
	 * 根据编号删除某一个角色
	 * @param roleId 角色编号
	 * @return 返回包含删除状态的统一返回值类型
	 * @throws Exception 抛出异常给全局异常处理
	 */
	@ApiOperation(notes = "delteteRoleById", httpMethod = "Get", value = "根据编号修改实体")
	@RequestMapping(value="/delteteRoleById",method=RequestMethod.GET)
	public ResultDo<Object> updateRole(Integer roleId)throws Exception{
		return roleService.deleteRole(roleId);
	}
}
