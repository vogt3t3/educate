package com.education.service;

import com.education.model.MajorModel;
import com.education.model.StudentModel;
import com.github.pagehelper.PageInfo;


/**
 * 学生管理业务层
 * @author 李梦鸽
 *
 */
public interface IStudentManagerService {
	/**
	 * 学生管理查询+分页+模糊
	 * @param pageNo   当前页
	 * @param pageSize  每页现实的条目
	 * @param studentName 模糊查询名字
	 * @return  学生信息列表  List<StudentModel>
	 * @throws Exception
	 */
	PageInfo<StudentModel> getStudentListPage(String studentName,Integer studentId,Integer pageNum,Integer pageSize) throws Exception;
	/**
	 * 根据Id查询学生的基本信息
	 * @param studentId 学生编号
	 * @return	反回StudentModel对象
	 * @throws Exception 抛出异常
	 */
	StudentModel queryStuById(Integer studentId) throws Exception;
	/**
	 * 根据Id查询学生的详细信息
	 * @param studentId 学生编号
	 * @return StudentModel 返回对象 
	 * @throws Exception 抛出异常
	 */
	StudentModel getStudentDetail(Integer studentId) throws Exception;
	/**
	 * 修改学生信息
	 * @param studentModel 学生对象
	 * @return 返回int
	 * @throws Exception 抛出异常
	 */
	int updateStudent(StudentModel studentModel) throws Exception;
	/**
	 * 删除学生信息（更改状态）
	 * @param StudentId 学生编号
	 * @return 返回int
	 * @throws Exception 抛出异常
	 */
	int deleteStudent(Integer studentId) throws Exception;
	



}
