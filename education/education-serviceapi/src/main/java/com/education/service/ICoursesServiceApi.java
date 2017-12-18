package com.education.service;

import java.util.List;
import com.education.model.CourseModel;
import com.github.pagehelper.PageInfo;

/**
 * 课程管理ServiceApi接口层
 * @author 赵睿慷
 *
 */
public interface ICoursesServiceApi {

    
    /**
     * 查询
     * @param courseName  传入课程名称进行模糊查询
     * @param courseId    传入课程ID进行精确查询
     * @param pageNo      当前页数
     * @param pageSize    每页显示数量
     * @return 所有数据.
     */

    PageInfo<CourseModel> selectCourseById(String courseName,Integer courseId,Integer pageNo, Integer pageSize);
      
    /**
     * 添加
     * @param courseModel 传入全部参数
     * @param majorName   传入专业名称
     * @return int.
     */
    int addCourse(CourseModel courseModel,String majorName);
    

    /**
     * 增加中的通过课程名称获取编号
     * @param majorName 传入专业名称
     * @return 专业编号.
     */
    int selectMajorById(String majorName);
    
    /**
    * 增加中的通过课程编号获取名称
    * @param teacherId 传入教师id
    * @return 教师名称.
    */
    List<CourseModel> selectTeacherById(int teacherId);
    
    /**
     * 修改
     * @param courseModel 传入所有数据
     * @return int.
     */
    int update(CourseModel courseModel);
    
    /**
     * 删除
     * @param courseId 传入修改ID
     * @return int.
     */
    int delete(int courseId);
    
}
