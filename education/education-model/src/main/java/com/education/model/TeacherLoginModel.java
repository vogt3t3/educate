package com.education.model;

import java.io.Serializable;

/**
 * 教师登陆实体
 * 
 * @author 杨振欣
 *
 */
public class TeacherLoginModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 教师编号
     */
    private int teacherId;
    /**
     * 登录密码
     */
    private String teacherPwd;
    /**
     * 真实姓名
     */
    private String teacherRealName;
    
	/**
	 * 记住我
	 */
	private boolean rememberMe;
    
    /**
     * 权限编号
     */
    private int roleId;
    /**
     * 等级说明
     */
    private String roleDesc;
    /**
     * 权限删除状态
     */
    private int roleDelete;
    

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }

    public String getTeacherRealName() {
        return teacherRealName;
    }

    public void setTeacherRealName(String teacherRealName) {
        this.teacherRealName = teacherRealName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public int getRoleDelete() {
        return roleDelete;
    }

    public void setRoleDelete(int roleDelete) {
        this.roleDelete = roleDelete;
    }

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "TeacherLoginModel [teacherId=" + teacherId + ", teacherPwd=" + teacherPwd + ", teacherRealName="
				+ teacherRealName + ", rememberMe=" + rememberMe + ", roleId=" + roleId + ", roleDesc=" + roleDesc
				+ ", roleDelete=" + roleDelete + "]";
	}

}
