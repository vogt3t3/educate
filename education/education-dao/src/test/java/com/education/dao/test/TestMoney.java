package com.education.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.dao.StudentDao;
import com.education.model.StudentModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml" })
public class TestMoney {

	@Autowired
	private StudentDao sd;
	
	
	
	@Test
//	public void test() {
//		try {
//		StudentModel op = sd.getMoney(1);
//			System.out.println(op);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	/**
	 * 缴纳费用
	 */
	public void payMoney() {
		try {
		StudentModel op = sd.payMoney("401504105840322358");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}