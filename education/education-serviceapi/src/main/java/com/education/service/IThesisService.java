package com.education.service;

import com.education.model.ResultDo;
import com.education.model.StuIndexDo;
import com.education.model.ThesisDo;
import com.github.pagehelper.PageInfo;

/**
 * 论文管理
 * @author 刘帅
 *
 */
public interface IThesisService {
    
    /**
     * 查询论文列表
     * @param pageNo 当前页
     * @param pageSize 每页显示条数
     * @return 论文列表
     */
    ResultDo<PageInfo<ThesisDo>> getThesis(Integer pageNo, Integer pageSize);
    
    /**
     * 添加论文成绩
     * @param thesisScore 论文成绩
     * @param thesisId 论文编号
     * @return 影响行数
     */
   ResultDo<Integer> addScore(int thesisScore,int thesisId);
}
