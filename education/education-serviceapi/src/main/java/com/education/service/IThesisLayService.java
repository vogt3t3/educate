package com.education.service;

import com.education.model.ResultDo;
import com.education.model.ThesisLayDo;
import com.github.pagehelper.PageInfo;

/**
 * 论文规范服务层
 * @author 刘帅
 *
 */
public interface IThesisLayService {
    
    /**
     * 获得论文规范列表
     * @param pageNo 当前页
     * @param pageSize  每页多少条
     * @return  论文规范分页列表
     */
    ResultDo<PageInfo<ThesisLayDo>> getThesisLay(Integer pageNo, Integer pageSize);
    
    /**
     * 添加论文规范
     * @param thesisLayDo 论文规范实体类
     * @return
     */
    ResultDo<ThesisLayDo> addThesisLay(ThesisLayDo thesisLayDo);
}
