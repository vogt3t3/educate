package com.education.service;

import com.education.model.ResultDo;
import com.education.model.SectionDo;
import com.education.model.StuIndexDo;
import com.github.pagehelper.PageInfo;

/**
 * 学习课程
 * @author 刘帅
 *
 */
public interface IStuCourseService {
    
    /**
     * 查询该课程所有章节
     * @param courseId 课程编号
     * @param pageNo 当前页
     * @param pageSize 数据条数
     * @return 带分页的所有章节
     */
    ResultDo<PageInfo<SectionDo>> querySection(int courseId,Integer pageNo, Integer pageSize);
}
