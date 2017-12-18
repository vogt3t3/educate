package com.education.dao;

import com.education.model.CourseInform;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 课程通知Dao接口.
 * @author 赵睿慷
 *
 */
public interface CourseInformDao {

  /**
   * 查询
   * 传入分页数据 
   * @return Major对像（集合）.
   */
  List<CourseInform> selectInformById(@Param("courseName")String courseName,@Param("informId")Integer informId);
  
  
  /**
   * 修改
   * @param courseInform 传入对象
   * @return int .
   */
  int updateCourseById(CourseInform courseInform);
  
  /**
   * 增加
   * @return int.
   */
  int addCourseById(CourseInform courseInform);
  
  /**
   * 增加专业
   * @param courseInforms 专业名称
   * @return 专业编号.
   */
  int addCourseByName(CourseInform courseInforms);
  
  /**
   * 增加中的通过课程名称获取编号
   * @param courseName 传入专业名称
   * @return 专业 .
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
   *@return int.
   */
  int deleteCourseById(int informId);
}
