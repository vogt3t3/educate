package com.education.dao;

import java.util.List;

import com.education.model.CourseModel;
import com.education.model.Judge;
import com.education.model.SelectExam;

public interface SelectExamDao {
    /**前端页面的分页数据
     * @param currentPages
     * @return 分页数据
     * 
     */
    List<SelectExam> getSelectPage(String searchMessage)throws Exception;

    /**
     * @return  返回下拉框级联页面数据
     * @throws Exception
     */
    List<Judge> getCourseSection()throws Exception;
    /**
     * @return  添加章节测试题库
     * @return 影响行数
     * @throws Exception
     */
    int addCourseSection(SelectExam se)throws Exception;
    
    
    /**添加期末测试题
     * @param jcs
     * @return影响行数
     * @throws Exception
     */
    int addExam(SelectExam se)throws Exception;
    
    
    
    /**添加入学考试
     * @param jcs
     * @return
     * @throws Exception
     */
    int addEnter(SelectExam se) throws Exception;

    /**课程下拉框前端页面信息
     * @return 返回下拉框
     * @throws Exception
     */
    List<CourseModel> getCourse()throws Exception;
    
    
    /**根据id 更新选择题
     * @return 影响行数
     * @throws Exception
     */
    int updateSelect(SelectExam se)throws Exception;
    
    
    /**根据id 删除对应信息
     * @param jcs
     * @return影响行数
     * @throws Exception
     */
    int deleteSelect(Integer selectId)throws Exception;
}
