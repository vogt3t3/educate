package com.education.service;


import com.education.model.ResultDo;
import com.education.model.StudentLoginModel;

/**
 * 学生登录业务层接口
 * @author 杨振欣
 *
 */
public interface IStudentLoginService {
	/**
	 * @param stuModel 学生登录实体
	 * @return 统一返回值类型
	 * @throws Exception 抛出业务层异常
	 */
	ResultDo<Object> studentLogin(StudentLoginModel stuModel)throws Exception;
}
