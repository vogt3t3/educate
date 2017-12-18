package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.StudentManagerDao;
import com.education.model.MajorModel;
import com.education.model.StudentModel;
import com.education.service.IStudentManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 学生管理实现层
 * @author 李梦鸽
 *
 */
@Service
public class StudentManagerServiceImpl implements IStudentManagerService{

	/**
	 * 管理学生接口的注入
	 */
	@Autowired
	private StudentManagerDao smd;
	
	
	/**
	 * 管理学生查询+分页+模糊
	 */
	@Override
	public PageInfo<StudentModel> getStudentListPage(String studentName,Integer studentId,Integer pageNum,Integer pageSize) throws Exception  {
		
		//如果当前页为空，则设为1，返回数据
		pageNum = pageNum==null?1:pageNum;
		//pageSize每页显示10条数据
		pageSize = pageSize==null?10:pageSize;
		//开启分页 参数为当前页和数据条数
		PageHelper.startPage(pageSize,pageNum);
		//查询返回结果
		List<StudentModel> listStu=smd.getStudentListPage(studentName,studentId,1);  
		PageInfo<StudentModel> pageInfo=new PageInfo<StudentModel>(listStu);
		System.out.println("lissisisisisisisissisi"+pageInfo);
		return pageInfo;
	}


	/**
	 * 管理学生根据Id查询学生基本信息
	 */

	@Override
	public StudentModel queryStuById(Integer studentId) throws Exception {
		StudentModel stuModel=smd.queryStuById(studentId);
		return stuModel;
	}
	
	/**
	 * 管理学生根据Id查询学生详细信息
	 */
	@Override
	public StudentModel getStudentDetail(Integer studentId) throws Exception {
		StudentModel stuModels=smd.getStudentDetail(studentId);
		return stuModels;
	}
	
	/**
	 * 管理学生修改
	 */
	@Override
	public int updateStudent(StudentModel studentModel) throws Exception {
		int updateStu=smd.updateStudent(studentModel);
		return updateStu;
	}
	/**
	 * 管理学生删除
	 */
	@Override
	public int deleteStudent(Integer studentId) throws Exception {
		int deleteStu=smd.deleteStudent(studentId);
		return deleteStu;
	}



}
