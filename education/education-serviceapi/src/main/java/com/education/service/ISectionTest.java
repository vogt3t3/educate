package com.education.service;
/**
 * 章节测试数据层接口
 * @author 赵京华
 */

import java.util.List;

import com.education.model.SelectModel;
import com.education.model.TestOfCourse;
import com.education.model.TestOfSection;

public interface ISectionTest {
	/**
     * 根据学生的编号查询出学生索要学习的所有课程
     * @param stuId 学生编号
     * @return List<SectionTree> tree类型
     * @throws Exception 抛出底层异常
     */
	List<TestOfCourse> getAllCourseByStuId(int stuId) throws Exception;
	/**
     * 根据传递过来的课程的编号查询该课程中章节的信息内容
     * @param courseId 课程的编号
     * @return List<TestOfSection> TestOfSection类型
     * @throws Exception 抛出底层异常
     */
	List<TestOfSection> getAllSectionByCourseId(int courseId)throws Exception;
	/**
     * 根据章节的id号获取一张选择题的试卷
     * @param sectionId 章节的id
     * @return List<TestOfCourse>
     * @throws Exception 抛出处理异常
     */
	List<SelectModel> getSlectsPaper(int sectionId) throws Exception;
	/**
     * 根据章节的id号和学生的id号向数据库中添加分数
     * @param sectionId 章节的id
     * @return List<TestOfCourse>
     * @throws Exception 抛出处理异常
     */
	int saveSectionsScore(int sectionId,int stuId,int score) throws Exception;
}










































