package com.education.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.model.TeacherLoginModel;

/**
 * 教师登陆实体
 * @author 杨振欣
 *
 */
public interface TeacherLoginDao {
/**
 * 教师登陆验证方法
 * @param teacherId 用户编号
 * @return TeacherLoginModel
 */
    TeacherLoginModel teacherlogin(Integer teacherId);
    
    
    /**
     * 根据角色编号查询权限
     * @param roleId 角色编号
     * @return 权限数组
     * @throws Exception 抛出底层异常
     */
    List<String> rolePermession(@Param("roleId") Integer roleId)throws Exception;
}
