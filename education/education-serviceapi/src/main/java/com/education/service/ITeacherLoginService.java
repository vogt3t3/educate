package com.education.service;

import java.util.List;


import com.education.model.PermissionModel;
import com.education.model.TeacherLoginModel;

/**
 * 用户登录
 * 
 * @author 杨振欣
 *
 */
public interface ITeacherLoginService {
    /**
     * 教师登陆验证方法
     * @param teacherId 教师编号
     * @return TeacherLoginModel 教师登陆实体
     * @throws Exception 抛出底层异常
     */
    TeacherLoginModel teacherlogin(Integer teacherId)throws Exception ;

	/**
	 * 登陆遍历所有权限
	 * @return List<PermissionModel> 返回所有权限
	 * @throws Exception 抛出底层异常
	 */
    List<PermissionModel> listAllPermission()throws Exception ;
    
    
    /**
     * 根据角色编号查询权限
     * @param roleId 角色编号
     * @return 权限数组
     * @throws Exception 抛出底层异常
     */
    List<String> rolePermession(Integer roleId)throws Exception;
}
