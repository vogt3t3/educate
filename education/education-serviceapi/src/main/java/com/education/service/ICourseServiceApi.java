package com.education.service;

import java.util.List;
import com.education.model.CourseInform;
import com.github.pagehelper.PageInfo;

/**
 * 课程通知ServiceApi接口
 * @author 赵睿慷
 *
 */
public interface ICourseServiceApi {

    /**
     * 查询
     * @param courseName 传入课程名称
     * @param informId   传入课程通知编号
     * @param pageNo     当前页
     * @param pageSize   总数据条数
     * @return PageInfo<CourseInform> 实体类分页
     */
    PageInfo<CourseInform> selectInformById(String courseName,Integer informId,Integer pageNo, Integer pageSize);
    /**
     * 修改
     * @param courseInform 传入实体类对象
     * @return int .
     */
    int updateCourseById(CourseInform courseInform,String courseName);
    
    /**增加
     * @param courseInform 传入实体类对象
     * @param courseName   传入课程名称
     * @return int 
     */
    int addCourseById(CourseInform courseInform,String courseName);
    
    /**
     * 增加中的通过课程名称获取编号
     * @param courseName 传入课程名称
     * @return 课程编号.
     */
    int selectCourseById(String courseName);
    
    /**
     * 增加中的通过教师编号获取名称
     * @param teacherId 传入教师id
     * @return 教师名称.
     */
    List<CourseInform> selectTeacherById(int teacherId);
    /**
     * 删除
     * @param informId 传入id号
     * @return int 
     */
    int deleteCourseById(int informId);
    
}
