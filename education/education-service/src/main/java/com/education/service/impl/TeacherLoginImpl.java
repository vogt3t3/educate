package com.education.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.PermissionDao;
import com.education.dao.TeacherLoginDao;
import com.education.model.PermissionModel;
import com.education.model.TeacherLoginModel;
import com.education.service.ITeacherLoginService;

/**
 * 教师登陆业务处理
 * 
 * @author 杨振欣
 *
 */
@Service
public class TeacherLoginImpl implements ITeacherLoginService {
    /**
     * 注入数据层业务
     */
    @Autowired
    private TeacherLoginDao teacherlogindao;
    /**
     * 注入权限层接口
     */
    @Autowired
    private PermissionDao permissionDao;

    /**
     * 教师登陆验证方法
     * @param teacherId 教师编号
     * @return TeacherLoginModel 教师登陆实体
     */
    public TeacherLoginModel teacherlogin(Integer teacherId) throws Exception {
    	//根据用户提供信息查询教师信息，供系统登录
    	TeacherLoginModel model=teacherlogindao.teacherlogin(teacherId);
        return model;
    }

    /**
	 * 登陆遍历所有权限
	 * @return List<PermissionModel> 返回所有全新
     * @throws Exception 
	 */
	public List<PermissionModel> listAllPermission() throws Exception {
		return permissionDao.listPermission();
	}
	
    
    /**
     * 根据角色编号查询权限
     * @param roleId 角色编号
     * @return 权限数组
     * @throws Exception 抛出底层异常
     */
	@Override
	public List<String> rolePermession(Integer roleId) throws Exception {
		// TODO Auto-generated method stub
		return teacherlogindao.rolePermession(roleId);
	}


}
