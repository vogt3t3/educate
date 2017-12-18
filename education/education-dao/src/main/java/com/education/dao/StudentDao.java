package com.education.dao;

import org.apache.ibatis.annotations.Param;
import com.education.model.StudentModel;

/**
 * 学生缴费状态数据层
 * @author 李梦鸽
 *
 */
public interface StudentDao {

	/**
	 * 根据学生编号查询缴费信息
	 * @return List<StudentEnterModel>对象
	 *  @throws Exception 抛出异常
	 */
	StudentModel  getMoney(@Param(value="studentId") Integer studentId) throws Exception;
	
	/**
	 * 根据身份证缴费
	 * @param studentId
	 * @return StudentModel 
	 * @throws Exception 抛出异常
	 */
	StudentModel  payMoney(@Param(value="studentIdcard") String studentIdcard) throws Exception;
	
	/**
	 * 更新学费缴纳信息
	 * @return 返回int
	 * @throws Exception抛出异常
	 */
	int updateMoney(StudentModel studentModel) throws Exception;

}





