package com.education.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.model.StudentScoreModel;

/**
 * 学生成绩数据层
 * @author ZHAORUN
 *
 */
public interface StudentScoreDao {
   
    
    /**查询学生各科成绩
     * @param stuId 学生stuId
     * @return 学生各科成绩集合List<StudentScoreModel>
     * @throws Exception 抛出异常
     */
    List<StudentScoreModel> listStudentScore(@Param(value="stuId") int stuId) throws Exception;
    
    /**查询学生课程成绩组成 
     * @param stuId 学生stuId
     * @param courseId 课程 courseId
     * @return 学生课程成绩组成  StudentScoreModel
     * @throws Exception 抛出异常
     */
    StudentScoreModel scoreGroup(@Param(value="stuId") int stuId,@Param(value = "courseId") int courseId) throws Exception;
    
    /** 添加成绩异议
     * @param stuId 学生stuId
     * @param courseId 课程 courseId
     * @param content 异议说明
     * @param date 异议时间
     * @return int 
     * @throws Exception 抛出异常
     */
    int addDissent(@Param(value="stuId") int stuId,@Param(value = "courseId") int courseId,@Param(value = "content") String content,@Param(value="date")  Date date) throws Exception;
   
}
