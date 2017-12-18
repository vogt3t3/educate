package com.education.service;

import java.util.List;
import java.util.Map;

import com.education.model.ExamCourseModel;
import com.education.model.ResultDo;


/**
 * 该模块是学生端期末考试模块的服务层接口
 * @author 申忠正
 */
public interface IStudentExam {
    
    /**
     * @param studentId 学生id
     * @return 该生的课程
     */
    List<ExamCourseModel> queryCourses(int studentId) throws Exception ; 
    /**
     * @return 查询返回学生的考试状态 0未预约    1已预约
     */
    ResultDo<Object> getexamstate(int studentId,int examId) throws Exception ;

    /**获得store题目列表  赵润 ----------------------------------------------------------------------------------
     * @param store 题库编号
     * @return List<SelectModel> store题目列表
     */
    @SuppressWarnings("rawtypes")
    ResultDo<Object> getTopicList(int score_type,int course_id) throws Exception;
    /**
     * @param map 成绩  课程id 学生id
     * @return
     * @throws Exception
     */
    int saveScore(Map map)throws Exception;
}
