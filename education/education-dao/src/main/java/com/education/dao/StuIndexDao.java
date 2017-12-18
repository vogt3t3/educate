package com.education.dao;

import java.util.List;

import com.education.model.StuIndexDo;

/**
 * 学生主页
 * @author 刘帅
 *
 */
public interface StuIndexDao {
    
    /**
     * 根据学生编号查询课程以及成绩
     * @return List<CourseModel>
     */
    List<StuIndexDo> queryCourse(int stuId);
}
