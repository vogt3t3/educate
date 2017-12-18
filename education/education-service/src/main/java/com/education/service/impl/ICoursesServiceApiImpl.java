package com.education.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.CourseModelDao;
import com.education.model.CourseModel;
import com.education.service.ICoursesServiceApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * ICoursesServiceApi实现类
 * @author 赵睿慷
 *
 */
@Service
public class ICoursesServiceApiImpl implements ICoursesServiceApi{

    /**
     * 注入CourseModelDao接口
     */
    @Autowired
    private CourseModelDao courseDao;
    
    /**
     * 查询(分页,模糊查询,精确查询)
     */
    @Override
    public PageInfo<CourseModel> selectCourseById(String courseName, Integer courseId, Integer pageNo, Integer pageSize) {
        // TODO Auto-generated method stub
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<CourseModel> list = courseDao.selectCourseById(courseName, courseId);
        PageInfo<CourseModel> page = new PageInfo<CourseModel>(list);
        return page;
    }
    /**
     * 增加
     */
    @Override
    public int addCourse(CourseModel courseModel,String majorName) {
        // TODO Auto-generated method stub
        CourseModel course = new CourseModel();
        course.setMajorName(majorName);
        courseDao.addMajorByName(course);
        courseModel.setMajorName(course.getMajorName());
        int add = courseDao.addCourse(courseModel);
        return add;
    }

    /**
     * 增加(通过课程名称获取ID)
     */
    @Override
    public int selectMajorById(String majorName) {
        // TODO Auto-generated method stub
        int select = courseDao.selectMajorById(majorName);
        return select;
    }
    /**
     * 增加(通过教师编号获取名称)
     */
    @Override
    public List<CourseModel> selectTeacherById(int teacherId) {
        // TODO Auto-generated method stub
        List<CourseModel> list = courseDao.selectTeacherById(teacherId);
        return list;
    }
    /**
     * 修改
     */
    @Override
    public int update(CourseModel courseModel) {
        // TODO Auto-generated method stub
        int update = courseDao.update(courseModel);
        return update;
    }
    /**
     * 删除
     */
    @Override
    public int delete(int courseId) {
        // TODO Auto-generated method stub
        int update = courseDao.delete(courseId);
        return update;
    }

    
    
}
