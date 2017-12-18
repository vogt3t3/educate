package com.education.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.education.model.TeacherModel;

/**
 * 教师Dao层接口
 * 
 * @author 张恒
 *
 */
public interface TeacherDao {

	/**
	 * 获取分页的模糊查询教师列表
	 * 
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            每页数据条目
	 * @return List<GetTeaInfoMap>教师集合
	 */
	List<TeacherModel> getPageTeachers(@Param("teacherId") Integer teacherId,
			@Param("teacherRealName") String teacherRealName);

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
	 * 根据课程名称得到id
	 * 
	 * @param courseName
	 *            课程名称
	 * @return 课程id
	 */
	int getCourseId(@Param("courseName") String courseName);

	/**
	 * 根据角色名的到角色Id
	 * 
	 * @param roleDesc
	 *            角色名称
	 * @return 角色id
	 */
	int getRoleId(@Param("roleDesc") String roleDesc);

	/**
	 * 删除指定教师
	 * 
	 * @param teacherId
	 *            教师Id
	 * @return int 影响行数
	 */
	int delTeacher(@Param("teacherId") Integer teacherId);

	/**
	 * 新增教师
	 * 
	 * @param teacherBean
	 *            新增的教师对象
	 * @return int 影响行数
	 */
	int insertTeacher(TeacherModel teacherBean);
}
