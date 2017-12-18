package com.education.service;

import com.education.model.PartSectionModel;
import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.github.pagehelper.PageInfo;

/**
 * 小节
 * @author 刘帅
 *
 */
public interface IPartSectionService {
    
    /**
     * 查询该章节下的所有小节
     * @param sectionId 章节编号
     * @param currentPage 当前页
     * @param pageSize 数据条数
     * @return 小节集合
     */
    ResultDo<PageInfo<PartSectionModel>> queryCourse(int sectionId,Integer currentPage, Integer pageSize);
}
