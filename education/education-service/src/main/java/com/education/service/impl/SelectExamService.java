package com.education.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.education.dao.SelectExamDao;
import com.education.model.CourseModel;
import com.education.model.Judge;
import com.education.model.SelectExam;
import com.education.service.SelectExamApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**李志鹏
 * @author Administrator
 *
 */
public class SelectExamService implements SelectExamApi {
    
    @Autowired
    private SelectExamDao sed;
    
    
    
    
    /**返回题库的页面数据包括分页数据,下拉框数据
     * @return 返回页面数据
     * @throws Exception 
     */
    @Override
    public Map<Object, Object> getPage(Integer currentPage, String searchMessage) throws Exception {
        Map<Object,Object> map = new HashMap<Object,Object>();
        List<Judge> listJudge=sed.getCourseSection();
        List<CourseModel> listCourse = sed.getCourse();
        PageHelper.startPage(currentPage, 10);
        List<SelectExam> listSelectPage=sed.getSelectPage(searchMessage);
        for(SelectExam one:listSelectPage){
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
        PageInfo<SelectExam> page = new PageInfo<SelectExam>(listSelectPage);
        map.put("page", page);
        map.put("listJudge", listJudge);
        map.put("listCourse", listCourse);
        return map;
    }
    /**
     * 添加章节选择题库
     * @throws Exception 
     */
    @Override
    public void addCourseSection(SelectExam se) throws Exception {
        // TODO Auto-generated method stub
        se.setSelectAddtime(new Date());
        sed.addCourseSection(se);
    }
    /**
     * 添加期末选择题库
     * @throws Exception 
     */
    @Override
    public void addExamService(SelectExam se) throws Exception {
        // TODO Auto-generated method stub
        se.setSelectAddtime(new Date());
        sed.addExam(se);
    }
    /**
     * 添加入学选择题库
     * @throws Exception 
     */
    @Override
    public void addEnterText(SelectExam se) throws Exception {
        // TODO Auto-generated method stub
        se.setSelectAddtime(new Date());
        sed.addEnter(se);
    }
    /**
     * 更新选择题库
     * @throws Exception 
     */
    @Override
    public void update(SelectExam se) throws Exception {
        // TODO Auto-generated method stub
        se.setModifyDate(new Date());
        se.setModifyPerson("李志鹏");
        sed.updateSelect(se);
    }
    /**
     * 删除选择题库
     * @throws Exception 
     */
    @Override
    public void delete(Integer selectId) throws Exception {
        // TODO Auto-generated method stub
        sed.deleteSelect(selectId);

    }
}
