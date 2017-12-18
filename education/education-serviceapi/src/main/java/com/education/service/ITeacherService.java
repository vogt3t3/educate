package com.education.service;

import java.util.List;
import com.education.model.TeacherModel;
import com.github.pagehelper.PageInfo;

/**
 * 教师服务层接口
 * 
 * @author 张恒
 *
 */
public interface ITeacherService {

	/**
	 * 获取教师信息
	 * 
	 * @param teacherId
	 *            教师id
	 * @param teacherRealName
	 *            教师姓名
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            每页显示多少条
	 * @return 返回教师分页信息
	 */
	PageInfo<TeacherModel> getPageTeachers(Integer teacherId, String teacherRealName, Integer pageNo, Integer pageSize);

	/**
	 * 获取教师角色名称
	 * 
	 * @return 角色名称集合
	 */
	List<String> getRole();

	/**
	 * 更改指定教师信息
	 * 
	 * @param teacherBean
	 *            封装页面的教师各个信息字段
	 * @return int 影响行数
	 */
	int updateTeacherInfo(TeacherModel teacherBean);

	/**
	 * 删除指定教师
	 * 
	 * @param teacherBean
	 *            封装页面的教师各个信息字段
	 * @return int 影响行数
	 */
	int delTeacher(Integer teacherId);

	/**
	 * 新增教师
	 * 
	 * @param teacherBean
	 *            新增的教师对象
	 * @return int 影响行数
	 */
	int insertTeacher(TeacherModel teacherBean);
}
