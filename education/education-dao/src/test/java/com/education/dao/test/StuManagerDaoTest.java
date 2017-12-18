/*package com.education.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.dao.StudentManagerDao;
import com.education.model.StudentModel;

*//**
 * 李梦鸽学生管理测试类
 * 
 * *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class StuManagerDaoTest {
	
	@Autowired
	private StudentManagerDao smd;
	
	
	@Test
	public void addStudent() throws Exception {
	System.out.println(smd);
	StudentModel sy=new StudentModel();
	int hp=smd.addStudent(sy);
	System.out.println(hp);
	
	}

}
*/