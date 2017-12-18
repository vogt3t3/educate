package com.education.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.education.model.CourseModel;
import com.education.model.ExamCourseModel;
import com.education.model.ExamInf;
import com.education.model.JudgeTopic;
import com.education.model.SelectModel;

/**
 * 学生端期末考试模块的数据层
 * @author 申忠正
 */
public interface StudentExamDao {
    
    /**
     * 根据学生id查他的所有课程
     * @return 该生的所有课程
     */
    List<CourseModel> queryCourses(int studentId) throws Exception ;
    
    /**
     * 根据课程 查考试信息
     * @param  courseId 课程id
     * @return  该生的所有考试信息
     */
    ExamCourseModel queryExams(int courseId) throws Exception ;
    
    /**
     * @param 学生id 考试id
     * @param 该学生的考试状态
     * @return
     */    
    int insertState(@Param("stu_id")int studentId,@Param("exam_id")int examId) throws Exception ;
    
    
    
    
    /**查询题库storeId选择题数量       ----------------------------------------------------------------------------------
     * @param scoreType scoreType
     * @return 
     */
    List<SelectModel> countSelect(@Param("score_type")int score_type,@Param("course_id")int course_id);
    
    /**查询题库storeId判断题数量
     * @param storeId 题库storeId
     * @return 判断题数量
     */
    List<JudgeTopic> countJudge(@Param("score_type")int score_type,@Param("course_id")int course_id);
    
    
    /**查询题库storeId判断题集合
     * @param judgeSet 判断题编号集合
     * @param storeId 题库storeId
     * @param course_id 课程id
     * @return 返回判断题集合
     */
    List<JudgeTopic> listJudge(@Param(value = "judgeSet") Set<Integer> judgeSet,@Param("score_type")int score_type,@Param("course_id")int course_id);
    
    /**查询题库storeId选择题集合
     * @param selectSet 选择题编号集合
     * @param storeId 题库storeId
     * @param course_id 课程id
     * @return 选择判断题集合
     */
    List<SelectModel> listSelect(@Param(value = "selectSet") Set<Integer> selectSet,@Param("score_type")int score_type,@Param("course_id")int course_id);
    /**
     * @param map 成绩  课程id 学生id
     * @return
     * @throws Exception
     */
    int saveScore(Map map)throws Exception;
}
