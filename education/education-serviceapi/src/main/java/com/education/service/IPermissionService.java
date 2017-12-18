package com.education.service;

import com.education.model.PageModel;
import com.education.model.PermissionModel;
import com.github.pagehelper.PageInfo;

/**
 * 
 * 权限管理接口
 * @author 杨振欣
 *
 */
public interface IPermissionService {

    /**查询所有权限
     * @param pageNo 当前页
     * @param pageSize 数据条数
     * @return PageInfo<PermissionModel>
     * @throws Exception 抛出底层异常
     */
    PageInfo<PermissionModel> listPermission(Integer pageNo, Integer pageSize)throws Exception;
    /** 添加权限
     * @param model 权限对象
     * @return Integer 返回影响的行数
     * @throws Exception 抛出底层异常
     */
    Integer addPermission(PermissionModel model)throws Exception;
    /**
     * @param model 修改的对象信息
     * @return Integer 返回影响的行数
     * @throws Exception 抛出底层异常
     */
    Integer updatePermission(PermissionModel model) throws Exception;
    
    /**
     * @param permissionId 传入权限的编号
     * @return Integer 返回影响的行数
     * @throws Exception 抛出底层异常
     */
    Integer deletePermission(Integer permissionId) throws Exception;
    /**
     * @param pageModel 传入分页实体
     * @return PageInfo<PermissionModel> 查询的权限列表
     * @throws Exception 抛出底层异常
     */
    PageInfo<PermissionModel>  getPermissonByRoleId(PageModel pageModel)throws Exception; 
    /**
     * @param pageModel 传入分页实体
     * @return PageInfo<PermissionModel> 查询的权限列表
     * @throws Exception 抛出底层异常
     */
    PageInfo<PermissionModel>  getPermissonByRoleIdNo(PageModel pageModel)throws Exception;
    

    /**
     * 给指定角色赋予指定的权限
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return 返回影响的行数
     * @throws Exception 抛出底层异常
     */
    Integer addRolePermission(Integer roleId,Integer permissionId)throws Exception; 
    
    /**
     * 删除指定角色指定的指定权限
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return 返回影响的行数
     * @throws Exception 抛出底层异常
     */
    Integer removeRolePermission(Integer roleId,Integer permissionId)throws Exception; 
    
}
