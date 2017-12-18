package com.education.dao;

import java.util.List;

import com.education.model.Courseware;
import com.education.model.CoursewareResId;
import com.education.model.StudyResourceModel;

/**
 * @author 申忠正
 *
 */
public interface CoursewareDao {
    /**
     * 
     * @return List<Courseware> 课件资源 --查询对应资源id的记录到页面(如果资源id为空，则查询所有课件资源)
     * @throws Exception 抛出数据层异常
     */
    List<Courseware> queryCourseware(int resourceId)throws Exception;
    /**
     *@param  coursewareId 课件id
     *@return 影响的行数
     *@throws Exception 业务处理层异常
     */
    int deleteCourseware(int coursewareId)throws Exception;
    /**
     * @param courseware  传入课件对象
     * @return 影响的行数 =1成功
     */
    int coursewareAdd(CoursewareResId courseware);
}
