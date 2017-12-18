package com.education.service;

import com.education.exception.ServiceException;
import com.education.model.StudentScoreModel;
import com.github.pagehelper.PageInfo;

/**
 * 服务层接口.
 * @author 冯云威
 *
 */
public interface ScoreService {
    /**
     * 返回PageInfo.
     * @param studentId 学生编号
     * @param studentName 学生姓名
     * @param pageNo 当前页
     * @param pageSize 一页显示的条数
     * @return PageInfo
     * @throws Exception 抛出异常
     */
    PageInfo<StudentScoreModel> queryByPage(Integer studentId,String studentName, Integer pageNo, Integer pageSize) throws Exception;
   
    /**
     * 根据成绩Id查询单个学生的学生成绩.
     * @param scoreId 成绩id
     * @return 学生成绩详情 
     * @throws Exception 抛出异常
     */
    StudentScoreModel getStuScore(Integer scoreId) throws Exception;
    
    /**
     * 修改学生成绩.
     * @param studentScoreModel 需要录入的学生成绩
     * @return 影响的行数
     * @throws ServiceException 抛出异常
     */
    int updateScore(StudentScoreModel studentScoreModel) throws ServiceException ;
     
    /**
     * 录入学生成绩
     * @param studentScoreModel 需要录入的学生成绩
     * @return 影响的行数
     * @throws Exception 抛出异常
     */
    int addScore(StudentScoreModel studentScoreModel) throws Exception;
}
