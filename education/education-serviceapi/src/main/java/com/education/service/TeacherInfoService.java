package com.education.service;

import com.education.model.TeacherModel;
import com.github.pagehelper.PageInfo;
/**
 * 教师信息
 * (数据层)
 * @author FYM
 *
 */
public interface TeacherInfoService {
    
    /**
     * 分页查询
     * @param stuId 学生id
     * @param pageNo 当前页
     * @param pageSize 数据条数
     * @return page
     * @throws Exception 抛出异常
     */
    PageInfo<TeacherModel> queryByPage(Integer stuId, Integer pageNo, Integer pageSize) throws Exception;
}
