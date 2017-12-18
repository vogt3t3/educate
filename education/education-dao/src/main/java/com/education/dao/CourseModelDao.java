package com.education.dao;

import com.education.model.CourseModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 课程管理Dao层接口
 * @author 赵睿慷.
 *
 */
public interface CourseModelDao {

  /**
   * 查询
   * @param courseName  传入课程名称进行模糊查询
   * @param courseId    传入课程ID进行精确查询
   * @return 所有数据.
   */
  List<CourseModel> selectCourseById(@Param("courseName")String courseName,@Param("courseId")Integer courseId);
    
  /**
   * 添加
   * @param courseModel 传入全部参数
   * @return int.
   */
  int addCourse(CourseModel courseModel);
  
  /**
   * 添加专业
   * @param courseModel 传入参数
   * @return int.
   */
  int addMajorByName(CourseModel courseModel);
  
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
