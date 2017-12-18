package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.TeacherInfoDao;
import com.education.model.TeacherModel;
import com.education.service.TeacherInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 遍历教师信息
 * 实现类(服务层实现类)
 * @author FYM
 *
 */
@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {
    
    /**
     * 注入接口实现类
     */
    /**
     * 教师信息接口
     */
    @Autowired
    private TeacherInfoDao teacherInfoDao;
    
    @Override
    public PageInfo<TeacherModel> queryByPage(Integer stuId, Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<TeacherModel> teaList=teacherInfoDao.getTeacherList(stuId);
        PageInfo<TeacherModel> page = new PageInfo<TeacherModel>(teaList);
        return page;
    }

}
