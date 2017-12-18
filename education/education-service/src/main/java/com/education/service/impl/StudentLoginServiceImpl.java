package com.education.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.StudentLoginDao;
import com.education.model.ResultDo;
import com.education.model.StudentLoginModel;
import com.education.service.IStudentLoginService;

/**
 * 学生登录业务层
 * @author 杨振欣
 *
 */
@Service
public class StudentLoginServiceImpl implements IStudentLoginService{
	@Autowired
	private StudentLoginDao studentloginDao;
	/**
	 * @param stuModel 学生登录实体
	 * @return 统一返回值类型
	 * @throws Exception 抛出业务层异常
	 */
	public ResultDo<Object> studentLogin(StudentLoginModel stuModel)throws Exception {
		//查询当前输入的用户编号判断学生是否存在（根据用户名查找学生信息）
		StudentLoginModel student = studentloginDao.studentLogin(stuModel.getUsername());
		ResultDo<Object> rs=new ResultDo<Object>();
		//判断学生是否存在
		if(student==null){
			rs.setResCode(100);
			rs.setResMsg("用户名不存在");
			return rs;
		}
		//学号存在且密码正确时
		if(student.getPassword().equals(stuModel.getPassword())){
			rs.setResCode(0);
			rs.setResMsg("登录成功");
			stuModel.setPassword("");
			rs.setResData(stuModel);
			return rs;
		}
		//密码错误时
		rs.setResCode(100);
		rs.setResMsg("用户名或者密码错误");
		return rs;
	}
}
