package com.education.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.model.CourseModel;
import com.education.model.Judge;
import com.education.model.JudgeCourseSection;

/**
 * @author 李志鹏
 *
 */
public interface CourseSectionJudge {
    
    
    /**前端页面的分页数据
     * @param currentPages
     * @return 分页数据
     * 
     */
    List<JudgeCourseSection> getJudgePage(String searchMessage)throws Exception;

    /**
     * @return  返回下拉框页面数据
     * @throws Exception
     */
    List<Judge> getCourseSection()throws Exception;
    /**
     * @return  添加章节测试题库
     * @return影响行数
     * @throws Exception
     */
    int addCourseSection(JudgeCourseSection jcs)throws Exception;
    
    
    /**添加期末测试题
     * @param jcs
     * @return影响行数
     * @throws Exception
     */
    int addExam(JudgeCourseSection jcs)throws Exception;
    
    
    
    /**添加入学考试
     * @param jcs
     * @return
     * @throws Exception
     */
    int addEnter(JudgeCourseSection jcs) throws Exception;

    /**课程下拉框前端页面信息
     * @return 返回下拉框
     * @throws Exception
     */
    List<CourseModel> getCourse()throws Exception;
    
    
    /**根据id 查找 判断题
     * @return 影响行数
     * @throws Exception
     */
    int updateJudgeCourseSection(JudgeCourseSection jcs)throws Exception;
    
    
    /**根据id 删除对应信息
     * @param jcs
     * @return影响行数
     * @throws Exception
     */
    int deleteJudgeCourseSection(Integer judgeId)throws Exception;
}
