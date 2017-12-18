package com.education.dao;

import java.util.List;

import com.education.model.SectionDo;
import com.education.model.SectionModel;

/**
 * 学习课程
 * @author 刘帅
 *
 */
public interface StuCourseDao {
    
    /**
     * 查询该课程对应的所有章节
     * @param courseId 课程编号
     * @return 所有章节
     */
    List<SectionDo> querySection(int courseId);
}
