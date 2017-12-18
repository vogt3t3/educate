package com.education.service;

import com.education.model.NoticeModel;
import com.github.pagehelper.PageInfo;

/**
 * 公告详情serciceApi
 * @author 赵睿慷
 *
 */
public interface INoticeServiceApi {

    /**
     * 查询
     * @param pageNo 当前页
     * @param pageSize 总数据条数
     * @return 通过全部信息并且进行分页
     */
    PageInfo<NoticeModel> selectNoticeById(Integer pageSize,Integer pageNo);
    
}
