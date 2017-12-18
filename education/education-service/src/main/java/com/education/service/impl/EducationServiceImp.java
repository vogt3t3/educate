package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.EducationPlanDao;
import com.education.model.Education;
import com.education.service.EducationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户服务
 * 
 * @author 徐鹏超
 *
 */
@Service
public class EducationServiceImp implements EducationService {

	/**dao层注入
	 * 
	 */
    @Autowired
	private EducationPlanDao educationPlanDao;

    @Override
	public PageInfo<Education> queryByPage(Integer pageNo, Integer pageSize) throws Exception {

		// TODO Auto-generated method stub
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 3 : pageSize;
		// 开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
		
		// 查询结果返回
        List<Education> edList = educationPlanDao.listEducation();
        System.out.println("service1111111");
        PageInfo<Education> page = new PageInfo<Education>(edList);
        return page;
    }
}
