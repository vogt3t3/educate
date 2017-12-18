package com.education.service;

import com.education.model.CourseDo;
import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.github.pagehelper.PageInfo;

/**
 * 课程详细信息服务类
 * @author 刘帅
 *
 */
public interface ICourseInfoService {

    /**
     * 得到课程详细信息
     * @param partId 小节编号
     * @return  课程详细信息
     */
    ResultDo<CourseDo> getCourseInfo(int partId);
}
