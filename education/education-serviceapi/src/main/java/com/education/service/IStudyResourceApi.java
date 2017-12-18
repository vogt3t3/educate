package com.education.service;

import com.education.model.StudyResourceModel;
import com.github.pagehelper.PageInfo;

/**
 * 导学资源service接口
 * @author 赵睿慷
 *
 */
public interface IStudyResourceApi {

    /**
     * 查询
     * @param courseName 传入课程名称进行模糊查询
     * @param resourceId 传入导学资源ID进行精确查询
     * @param pageNo     当前页
     * @param pageSize   总数据条数
     * @return PageInfo<CourseInform> 实体类分页
     */
    PageInfo<StudyResourceModel> getStudy(String courseName,Integer resourceId,Integer pageNo, Integer pageSize);
}
