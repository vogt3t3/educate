package com.education.service;

import java.util.List;
import java.util.Map;

import com.education.model.Judge;
import com.education.model.JudgeCourseSection;

/**
 * @author 李志鹏
 *
 */
public interface ICourseSectionApi {
    
    /**查询内容
     * @return 返回一个集合里面是Judge实例化
     */
    Map<Object,Object> getPage(Integer currentPage,String searchMessage) throws Exception;
    
    
    /**添加判断题章节测试
     * @param JudgeCourseSection 判断题章节测试类
     * @throws Exception
     */
    void addCourseSectionService(JudgeCourseSection jcs) throws Exception;
    /**添加判断题期末测试
     * @param JudgeCourseSection 判断题章节测试类
     * @throws Exception
     */
    
    void addExamService(JudgeCourseSection jcs) throws Exception;
    
    
    /**添加入学测试题
     * @param jcs
     * @throws Exception
     */
    void addEnterService(JudgeCourseSection jcs) throws Exception;
    
    
    /**更新数据
     * @param JudgeCourseSection
     * @throws Exception
     */
    void update(JudgeCourseSection jcs) throws Exception; 
    
    
    
    /**删除数据
     * @param jcs
     * @throws Exception
     */
    void delete(Integer judgeId)throws Exception;
}
