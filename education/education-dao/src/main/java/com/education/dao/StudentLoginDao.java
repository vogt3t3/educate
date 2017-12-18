package com.education.dao;

import org.apache.ibatis.annotations.Param;

import com.education.model.StudentLoginModel;

/**
 * 学生登录数据层接口
 * @author 杨振欣
 *
 */
public interface StudentLoginDao {
	/**
	 * 学生登录
	 * @param userName 根据登录名查找
	 * @return 返回学生登录实体
	 * @throws Exception 抛出底层异常
	 */
	StudentLoginModel studentLogin(@Param("student_name") Integer userName)throws Exception;
	
}
