package com.education.model;

import java.io.Serializable;

/**
 * 用户登陆实体类
 * 
 * @author 杨振欣
 *
 */
public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用户姓名
     * 
     * @author Administrator
     *
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 记住我
     */
    private boolean rememberMe;
    /**
     * 权限等级
     */
    private int roleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", rememberMe=" + rememberMe + ", roleId="
				+ roleId + "]";
	}

	
}
