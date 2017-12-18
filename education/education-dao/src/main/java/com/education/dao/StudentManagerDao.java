package com.education.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.education.model.StudentModel;

/**
 * 学生管理数据层
 * @author 李梦鸽
 *
 */
public interface StudentManagerDao {
	/**
	 * 分页查询学生信息
	 * @param studentName 
	 * @param pageNum 当前页
	 * @param pageSize 每页数据条目
	 * @return List<StudentModel>管理学生集合
	 * @throws Exception  抛出异常
	 */
	List<StudentModel> getStudentListPage(@Param(value="student_name") String studentName,@Param(value="student_id") Integer studentId,@Param(value="student_delete") int studentDelete) throws Exception;
	
	/**
	 * 根据Id查询学生基本信息
	 * @param studentId 学生编号
	 * @return  返回StudentModel 
	 * @throws Exception 抛出异常
	 */
	StudentModel queryStuById(Integer studentId) throws Exception;
	
	/**
	 * 根据Id查询学生详细信息
	 * @param studentId 学生编号
	 * @return StudentModel 返回对象
	 * @throws Exception 抛出异常
	 */
	StudentModel getStudentDetail(Integer studentId) throws Exception;
	/**
	 * 修改学生信息
	 * @param studentModel 学生对象
	 * @return 返回int类型
	 * @throws Exception 抛出异常
	 */
	int updateStudent(StudentModel studentModel) throws Exception;
	/**
	 * 删除学生的状信息（状态）
	 * @param studentDelete  删除学生的状态 1 代表存在   0代表删除
	 * @return 返回int
	 * @throws Exception 抛出异常
	 */
	int deleteStudent(Integer studentId) throws Exception;
	

	
	
}
