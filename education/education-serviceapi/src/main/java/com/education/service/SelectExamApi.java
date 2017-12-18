package com.education.service;

import java.util.Map;
import com.education.model.JudgeCourseSection;
import com.education.model.SelectExam;

public interface SelectExamApi {
    /**查询内容
     * @return 返回一个集合里面是Judge实例化
     */
    Map<Object,Object> getPage(Integer currentPage,String searchMessage) throws Exception;
    
    
    /**添加判断题章节测试
     * @param JudgeCourseSection 判断题章节测试类
     * @throws Exception
     */
    void addCourseSection(SelectExam se) throws Exception;
    /**添加判断题期末测试
     * @param JudgeCourseSection 判断题章节测试类
     * @throws Exception
     */
    
    void addExamService(SelectExam se) throws Exception;
    
    
    /**添加入学测试题
     * @param jcs
     * @throws Exception
     */
    void addEnterText(SelectExam se) throws Exception;
    
    
    /**更新数据
     * @param JudgeCourseSection
     * @throws Exception
     */
    void update(SelectExam se) throws Exception; 
    
    
    
    /**删除数据
     * @param jcs
     * @throws Exception
     */
    void delete(Integer judgeId)throws Exception;
}
