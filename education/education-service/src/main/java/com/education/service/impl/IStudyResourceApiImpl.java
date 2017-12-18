package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.StudyResourceModelDao;
import com.education.model.StudyResourceModel;
import com.education.service.IStudyResourceApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 导学资源Service接口实现类
 * @author 赵睿慷
 *
 */
@Service
public class IStudyResourceApiImpl implements IStudyResourceApi{

    
    /**
     * 注入StudyResourceModelDao导学资源接口
     */
    @Autowired
    private StudyResourceModelDao study;
    /**
     * 查询(精确查询,模糊查询)
     */
    @Override
    public PageInfo<StudyResourceModel> getStudy(String courseName, Integer resourceId, Integer pageNo,
            Integer pageSize) {
        // TODO Auto-generated method stub
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<StudyResourceModel> list = study.getStudy(courseName, resourceId);
        PageInfo<StudyResourceModel> page = new PageInfo<StudyResourceModel>(list);
        System.out.println("Impl层total----"+page.getTotal());
        System.out.println("Impl层list----"+list);
        return page;
    }
    
    

    
}
