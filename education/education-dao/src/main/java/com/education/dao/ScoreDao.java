package com.education.dao;

import com.education.exception.ServiceException;
import com.education.model.StudentScoreModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
* 数据层接口（学生成绩）.
* @author 冯云威
*
*/
public interface ScoreDao {
  /**
  * 得到学生成绩.
  * @param studentId 学生编号
  * @param studentName 学生名字
  * @return 学生成绩
  */
  List<StudentScoreModel> stuScoreList(@Param("studentId") Integer studentId,
          @Param("studentName") String studentName)throws Exception;
  
  /**
   * 查询单个学生的学生成绩.
  * @param scoreId 学生编号
  * @return 学生成绩详情
  */
  StudentScoreModel getStuScore(@Param("scoreId") Integer scoreId) throws Exception;
  
  
  /**
  * 修改学生成绩信息 .
  * @param studentScoreModel 学生成绩类.
  * @return 影响行数
  */
  int updateScore(StudentScoreModel studentScoreModel) throws ServiceException;
  
  /**
  * 添加成绩信息.
  * @param studentScoreModel 学生成绩类
  * @return 影响的行数
  * @throws ServiceException 抛出异常
  */
  int addScore(StudentScoreModel studentScoreModel) throws ServiceException;
  
  /**
  * 根据学生课程名查询学生Id.
  * @param courseName 课程名称 
  * @return 返回学生的Id
  * @throws Exception 抛出异常
  */
  int getcourseId(String courseName) throws Exception;
  
  /**
  * 根据学生的姓名查询学生Id.
  * @param studentName 学生名称
  * @return 学生Id
  * @throws Exception 抛出异常
  */
  int getstuId(String studentName) throws Exception;
  
}
