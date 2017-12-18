package com.education.dao;

import com.education.model.CourseDo;

/**
 * 课程详细信息
 * @author 刘帅
 *
 */
public interface CourseInfoDao {
    
    /**
     * 根据小节编号获得视频以及课程详细信息
     * @param partId 小节编号
     * @return 课程对象
     */
    CourseDo getCourseInfo(int partId); 
}
