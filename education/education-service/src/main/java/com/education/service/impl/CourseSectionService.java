package com.education.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.CourseSectionJudge;
import com.education.model.CourseModel;
import com.education.model.EnrollStudents;
import com.education.model.Judge;
import com.education.model.JudgeCourseSection;
import com.education.service.ICourseSectionApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @author Administrator
 *
 */
@Service
public class CourseSectionService implements ICourseSectionApi{
    
    @Autowired
    private CourseSectionJudge csj;
    
    
    /**返回题库的页面数据包括分页数据,下拉框数据
     * @return 返回页面数据
     * @throws Exception 
     */
    @Override
    public Map<Object,Object> getPage(Integer currentPage,String searchMessage) throws Exception {
        
        
        Map<Object,Object> map = new HashMap<Object,Object>();
        List<Judge> listJudge=csj.getCourseSection();
        List<CourseModel> listCourse = csj.getCourse();
        PageHelper.startPage(currentPage, 10);
        List<JudgeCourseSection> listJudgePage=csj.getJudgePage(searchMessage);
        for(JudgeCourseSection one:listJudgePage){
            if(one.getScoreType()==1){
                one.setScoreTypeName("期末考试");
            }
            if(one.getScoreType()==2){
                one.setScoreTypeName("章节考试");
            }
            if(one.getScoreType()==3){
                one.setScoreTypeName("入学考试");
            }
           
        }
        PageInfo<JudgeCourseSection> page = new PageInfo<JudgeCourseSection>(listJudgePage);
        map.put("page", page);
        map.put("listJudge", listJudge);
        map.put("listCourse", listCourse);
        return map;
    }

    /**
     * 添加章节判断题库
     * @throws Exception 
     */
    @Override
    public void addCourseSectionService(JudgeCourseSection jcs) throws Exception {
        jcs.setJudgeAddtime(new Date());
        jcs.setJudgeAdduser("李志鹏");
        csj.addCourseSection(jcs);
        
    }
    /**
     * 添加期末判断题库
     * @throws Exception 
     */
    @Override
    public void addExamService(JudgeCourseSection jcs) throws Exception {
        jcs.setJudgeAddtime(new Date());
        jcs.setJudgeAdduser("李志鹏");
        csj.addExam(jcs);
        
    }
    /**添加入学判断题
     *
     * @throws Exception 
     */
    @Override
    public void addEnterService(JudgeCourseSection jcs) throws Exception {
        jcs.setJudgeAddtime(new Date());
        jcs.setJudgeAdduser("李志鹏");
        csj.addEnter(jcs);
    }
    /**更新数据
    * @return JudgeCourseSection
    * @throws Exception 
    */
    @Override
    public void update(JudgeCourseSection jcs) throws Exception {
        jcs.setJudgeModifyDate(new Date());
        jcs.setJudgeModifyPerson("李志鹏");
        csj.updateJudgeCourseSection(jcs);
    }
    /**删除数据
     * @return JudgeCourseSection
     * @throws Exception 
     */
    @Override
    public void delete(Integer judgeId) throws Exception {
        csj.deleteJudgeCourseSection(judgeId);
        
    }

  
   
   

}
