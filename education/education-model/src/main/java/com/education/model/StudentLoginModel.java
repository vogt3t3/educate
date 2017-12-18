package com.education.model;

import java.io.Serializable;

/**
 * 学生登录实体类
 * @author 杨振欣
 *
 */
public class StudentLoginModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 学生登录名（学生编号）
	 */
	private Integer username;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 是否记住我
	 */
	private boolean rememberMe;
	public Integer getUsername() {
		return username;
	}
	public void setUsername(Integer username) {
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
		return "StudentLoginModel [username=" + username + ", password=" + password + ", rememberMe=" + rememberMe
				+ "]";
	}
	
	

}
