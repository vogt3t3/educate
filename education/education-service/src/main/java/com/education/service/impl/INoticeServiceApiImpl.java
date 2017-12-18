package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.NoticeModelDao;
import com.education.model.NoticeModel;
import com.education.service.INoticeServiceApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * serciveApi实现类
 * @author 赵睿慷
 *
 */
@Service
public class INoticeServiceApiImpl implements INoticeServiceApi{

    /**
     * 注入NoticeModelDao接口
     */
    @Autowired
    private NoticeModelDao nmd;
    
    /**
     * 查询公告详情
     */
    @Override
    public PageInfo<NoticeModel> selectNoticeById( Integer pageSize,Integer pageNo) {
        System.out.println("服务层当前页是:"+pageNo);
        // TODO Auto-generated method stub
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<NoticeModel> list = nmd.selectNoticeById();
        PageInfo<NoticeModel> page = new PageInfo<NoticeModel>(list);
        return page;
    }

    
    
}
