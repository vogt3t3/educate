package com.education.service;

import java.util.List;

import com.education.model.MajorModel;
import com.education.model.StudentModel;

/**
 * 学生缴费状态业务层
 * 
 * @author 李梦鸽
 *
 */
public interface IStuMoneyService {

	/** 
	 * 查询缴费信息
	 * @param studentId 
	 *             学生编号
	 * @return List<StudentModel> 
	 *             统一返回
	 * @throws Exception 
	 *             抛出异常
	 */
	List<StudentModel> getMoney(Integer studentId) throws Exception;

	/**
	 * 根据身份证缴费
	 * 
	 * @return StudentModel 
	 *             学生对象
	 * @throws Exception
	 *             抛出异常
	 */
	StudentModel payMoney(String studentIdcard) throws Exception;

	/**
	 * 根据身份证更新学生缴费信息
	 * 
	 * @param studentModel 
	 *              学生对象
	 * @return      返回int
	 * @throws Exception
	 *             抛出异常
	 */
	int updateMoney(StudentModel studentModel) throws Exception;
	


}
