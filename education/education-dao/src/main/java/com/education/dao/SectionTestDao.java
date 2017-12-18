package com.education.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.model.SelectModel;
import com.education.model.TestOfCourse;
import com.education.model.TestOfSection;

/**
 * 章节测试管理
 * @author 赵京华
 *
 */
public interface SectionTestDao {
	/**
     * 根据学生编号查询出该学生学习的课程
     * @param stuId 学生编号
     * @return List<TestOfCourse>
     * @throws Exception 抛出处理异常
     */
	List<TestOfCourse> getCourseByStuId(int stuId) throws Exception;
	/**
     * 根据课程的编号查询该课程中的所有章节信息
     * @param courseId 课程编号
     * @return List<TestOfCourse>
     * @throws Exception 抛出处理异常
     */
	List<TestOfSection>  getSectionByCourseId(int courseId) throws Exception;
	/**
     * 根据章节的id号获取一张选择题的试卷
     * @param sectionId 章节的id
     * @return List<TestOfCourse>
     * @throws Exception 抛出处理异常
     */
	List<SelectModel> getSlectPaper(int sectionId) throws Exception;
	/**
     * 根据课程编号和学生编号查询成绩
     * @param sectionId 章节的id，stuId 学号
     * @return int学生的分数
     * @throws Exception 抛出处理异常
     */
	Integer getScore(@Param("sectionId") int sectionId,@Param("stuId") int stuId) throws Exception;
	/**
     * 向章节测试分数表中添加数据
     * @param sectionId 章节的id，stuId 学号，score分数
     * @return int插入了几条数据
     * @throws Exception 抛出处理异常
     */
	int saveSectionScore(@Param("sectionId") int sectionId,@Param("stuId") int stuId,@Param("score") int score)throws Exception;
	/**
     * 更新分数
     * @param sectionId 章节的id，stuId 学号，score分数
     * @return int插入了几条数据
     * @throws Exception 抛出处理异常
     */
	int updateSectionScore(@Param("sectionId") int sectionId,@Param("stuId") int stuId,@Param("score") int score)throws Exception;
	/**
     * 根据小节的编号查询出课程的编号
     * @param sectionId 章节的id
     * @return int课程的id编号
     * @throws Exception 抛出处理异常
     */
	Integer getCourseId(int sectionId) throws Exception;
	/**
     * 根据课程的编号查询出该课程中章节的数量
     * @param courseId 章节的id
     * @return int该课程中章节的数量
     * @throws Exception 抛出处理异常
     */
	Integer getAllSection(int courseId) throws Exception;
	/**
     * 根据课程的编号和学号查询出该课程中所有章节的成绩总和
     * @param stuId 学号，courseId 课程编号
     * @return int成绩总和
     * @throws Exception 抛出处理异常
     */
	Integer getSectionScoureSum(@Param("stuId") int stuId,@Param("courseId") int courseId) throws Exception;
	/**
     * 根据课程编号和学号查询成绩编号
     * @param stuId 学号，courseId 课程编号
     * @return int成绩总和
     * @throws Exception 抛出处理异常
     */
	Integer getScoureId(@Param("stuId") int stuId,@Param("courseId") int courseId) throws Exception;
	/**
     * 添加章节成绩
     * @param stuId 学号，courseId 课程编号，scour章节平均成绩
     * @return int添加了几条数据
     * @throws Exception 抛出处理异常
     */
	Integer addSectionScoreToFanally(@Param("stuId") int stuId,@Param("courseId") int courseId,@Param("scour") int scour) throws Exception;
	/**
     * 更新章节成绩
     * @param stuId 学号，courseId 课程编号，scour章节平均成绩
     * @return int更新了几条数据
     * @throws Exception 抛出处理异常
     */
	Integer updateSectionScoreToFanally(@Param("stuId") int stuId,@Param("courseId") int courseId,@Param("scour") int scour) throws Exception;
}

















































