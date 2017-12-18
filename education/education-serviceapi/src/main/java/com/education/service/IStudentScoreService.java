package com.education.service;

import java.util.Date;
import java.util.List;

import com.education.model.ResultDo;
import com.education.model.StudentScoreModel;

/**
 * 学生分数服务接口
 * @author ZHAORUN
 *
 */
public interface IStudentScoreService {

	/** 查询学生各科分数
	 * @param stuId 学生编号
	 * @return 学生各科分数列表  List<StudentScoreModel>
	 * @throws Exception 抛出查询学生各科分数异常
	 */
	ResultDo<List<StudentScoreModel>> getListStudentScore(int stuId) throws Exception;
	
	/** 查询学生课程分数组成
	 * @param stuId 学生编号
	 * @param courseId 课程编号
	 * @return 学生课程章节分数列表  List<StudentScoreModel>
	 * @throws Exception 抛出查询学生课程章节分数异常
	 */
	ResultDo<StudentScoreModel> getListStudentSectionScore(int stuId,int courseId) throws Exception;
	
	/** 异议添加
	 * @param stuId 学生编号
	 * @param courseId 课程编号
	 * @param content 异议说明
	 * @param date 异议时间
	 * @return 返回异议添加结果
	 * @throws Exception 抛出异议添加异常
	 */
	ResultDo<String> doAddDissent(int stuId,int courseId,String content,Date date) throws Exception;
	
}
