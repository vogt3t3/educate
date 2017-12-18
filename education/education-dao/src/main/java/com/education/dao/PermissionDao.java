package com.education.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.model.PermissionModel;

/**
 * 权限管理业务接口
 * @author 杨振欣
 *
 */
public interface PermissionDao {
    /** 查询所有权限
     * @return List<PermissionModel>
     * @throws Exception 抛出底层异常
     */
    List<PermissionModel> listPermission()throws Exception;
    /** 添加权限
     * @param model 权限对象
     * @return Integer 返回影响的行数
     * @throws Exception 抛出底层异常
     */
    Integer addPermission(PermissionModel model)throws Exception;
    
    /**
     * @param model 修改的对象信息
     * @return 返回影响的行数
     * @throws Exception 抛出底层异常
     */
    Integer updatePermission(PermissionModel model) throws Exception;
    
    /**
     * @param permissionId 传入权限的编号
     * @return 返回影响的行数
     * @throws Exception 抛出底层异常
     */
    Integer deletePermission(Integer permissionId) throws Exception;
    /**
     * 根据角色编号查询该角色所拥有的权限列表
     * @param roleId 角色编号
     * @return 返回权限列表
     */
    List<PermissionModel> getPermissonByRoleId(@Param("role_id") Integer roleId)throws Exception; 
    /**
     * 根据角色编号查询该角色还未拥有的权限列表
     * @param roleId 角色编号
     * @return 返回权限列表
     */
    List<PermissionModel> getPermissonByRoleIdNo(@Param("role_id") Integer roleId)throws Exception;
    
    /**
     * 根据角色编号和权限编号查看权限角色表是否包含该权限
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return Integer 角色权限编号
     */
    Integer getPermissionHave(@Param("roleId") Integer roleId,@Param("permissionId") Integer permissionId);
    
    
    /**
     * 给用户授权（当表中没有该权限时（不包含删除权限为空的情况））
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return 影响的行数
     */
    Integer addRolePermission(@Param("roleId") Integer roleId,@Param("permissionId") Integer permissionId);
    /**
     * 给用户授权（当表该角色的该权限删除状态为空时，修改删除状态即可））
     * @param id 角色权限编号
     * @return 影响的行数
     */
    Integer updateRolePermission(@Param("Id") Integer id);

    /**
     * 移除某个角色的某个权限
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return 返回影响的行数
     */
    Integer removeRolePermission(@Param("roleId")Integer roleId,@Param("permissionId")Integer permissionId);
}
