package com.education.dao.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.education.dao.RoleDao;

public class TestRoleDao extends TesDao {
	@Autowired
	private RoleDao roleDao;
	@Test
	public void testRole(){
		try {
			System.out.println(roleDao.listAllRole().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
