package com.education.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.TeacherDao;
import com.education.model.TeacherModel;
import com.education.service.ITeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 服务层教师借口实现
 * 
 * @author 张恒
 *
 */
@Service
public class TeacherServiceImpl implements ITeacherService {

	/**
	 * 自动注入数据层的教师接口 TeacherDao
	 */
	@Autowired
	private TeacherDao td;

	/**
	 * 引入log4j日志记录
	 */
	private static Logger logger = Logger.getLogger(TeacherServiceImpl.class.getName());

	@Override
	public PageInfo<TeacherModel> getPageTeachers(Integer teacherId, String teacherRealName, Integer pageNo,
			Integer pageSize) {
		logger.info("这里是服务层实现");
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<TeacherModel> teacherList = td.getPageTeachers(teacherId, teacherRealName);
		PageInfo<TeacherModel> pageList = new PageInfo<TeacherModel>(teacherList);
		return pageList;
	}

	@Override
	public int updateTeacherInfo(TeacherModel teacherBean) {
		int courseId = td.getCourseId(teacherBean.getCourseName());
		int roleId = td.getRoleId(teacherBean.getRoleDesc());
		teacherBean.setCourseId(courseId);
		System.out.println("courseId:" + courseId);
		teacherBean.setRoleId(roleId);
		System.out.println("roleId:" + roleId);
		int rsnums = td.updateTeacherInfo(teacherBean);
		System.out.println(rsnums);
		logger.info("这是服务曾实现的影响行数" + rsnums);
		return rsnums;
	}

	@Override
	public int delTeacher(Integer teacherId) {
		int rsnums = td.delTeacher(teacherId);
		return rsnums;
	}

	@Override
	public int insertTeacher(TeacherModel teacherBean) {
		int courseId = td.getCourseId(teacherBean.getCourseName());
		int roleId = td.getRoleId(teacherBean.getRoleDesc());
		teacherBean.setCourseId(courseId);
		teacherBean.setRoleId(roleId);
		int rsnums = td.insertTeacher(teacherBean);
		return rsnums;
	}

	@Override
	public List<String> getRole() {
		List<String> roleDesc = td.getRole();
		return roleDesc;
	}

}
