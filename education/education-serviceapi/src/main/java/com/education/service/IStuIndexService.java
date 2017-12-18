package com.education.service;

import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.github.pagehelper.PageInfo;

/**
 * 学生主页
 * @author 刘帅
 *
 */
public interface IStuIndexService {
    
    /**
     * 查询该学生的课程
     * @param stuId 学生编号
     * @param currentPage 当前页
     * @param pageSize 数据条数
     * @return 课程集合
     */
    ResultDo<PageInfo<StuIndexDo>> queryCourse(int stuId,Integer pageNo, Integer pageSize);
}
