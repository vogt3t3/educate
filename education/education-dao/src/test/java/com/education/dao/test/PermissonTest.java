package com.education.dao.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.education.dao.PermissionDao;

public class PermissonTest extends TesDao {
	@Autowired
	private PermissionDao permissiondao;
	@Test
	public void say(){
		try {
			System.out.println(permissiondao.getPermissonByRoleIdNo(1).size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
