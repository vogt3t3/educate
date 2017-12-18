package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.CourseInformDao;
import com.education.model.CourseInform;
import com.education.service.ICourseServiceApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ICourseServiceApi实现类
 * @author 赵睿慷
 *
 */
@Service
public class ICourseServiceApiImpl implements ICourseServiceApi{

    /**
     * 注入CourseInformDao接口
     */
    @Autowired
    private CourseInformDao courseInformDao ;
    
    /**
     * 查询(分页)
     */
    @Override
    public PageInfo<CourseInform> selectInformById(String courseName,Integer informId,Integer pageNo, Integer pageSize) {
        // TODO Auto-generated method stub
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<CourseInform> list = courseInformDao.selectInformById(courseName,informId);
 
        PageInfo<CourseInform> page = new PageInfo<CourseInform>(list);
        return page;
    }

    /**
     *修改 
     */
    @Override
    public int updateCourseById(CourseInform courseInform,String courseName) {
        System.out.println(courseInform.getCourseId()+"-------------------");
        // TODO Auto-generated method stub
        //int a = courseInformDao.selectCourseById(courseName);
        //courseInform.setCourseId(a);
        int update = courseInformDao.updateCourseById(courseInform);
        return update;
    }

    /**
     * 增加
     */
    @Override
    public int addCourseById(CourseInform courseInform,String courseName) {
        // TODO Auto-generated method stub
        CourseInform courseInforms = new CourseInform();
        courseInforms.setCourseName(courseName);
        courseInformDao.addCourseByName(courseInforms);
        courseInform.setCourseId(courseInforms.getCourseId());
        courseInform.setCourseName(courseInforms.getCourseName());
        System.out.println("3333333:"+courseInforms.getCourseName());
        int addById = courseInformDao.addCourseById(courseInform);
        return addById;
    }
    /**
     * 删除
     */
    @Override
    public int deleteCourseById(int informId) {
        // TODO Auto-generated method stub
        int del = courseInformDao.deleteCourseById(informId);
        return del;
    }
    /**
     * 增加(通过教师编号获取名称)
     */
    @Override
    public List<CourseInform> selectTeacherById(int teacherId) {
        // TODO Auto-generated method stub
        List<CourseInform> list = courseInformDao.selectTeacherById(teacherId);
        return list;
    }

    /**
     * 增加(通过课程编号获取名称)
     */
    @Override
    public int selectCourseById(String courseName) {
        // TODO Auto-generated method stub
        int select = courseInformDao.selectCourseById(courseName);
        return select;
    }
    
}
