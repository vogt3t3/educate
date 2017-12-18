package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.EducationPlanDao;
import com.education.model.Education;
import com.education.model.ErrorCode;
import com.education.model.MajorModel;
import com.education.service.EdService;
import com.education.service.exception.ServiceException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 用户服务
 * 
 * @author 徐大仁
 *
 *
 */
@Service
public class EdServiceImp implements EdService {

	/**dao层注入
	 * 
	 */
    @Autowired
	private EducationPlanDao educationPlanDao;

    @Override
	public PageInfo<Education> queryByPage(Integer educationPlanId,String majorName,Integer pageNo, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 3 : pageSize;
		// 开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        
		// 查询结果返回
        List<Education> edList = educationPlanDao.queryEducationPlan(educationPlanId, majorName);
        PageInfo<Education> page = new PageInfo<Education>(edList);
        return page;
    }

    @Override
	public int addEducationPlan(Education education) throws Exception {
		// TODO Auto-generated method stub
        int record = educationPlanDao.addEducationPlan(education);
	
        if (record < 0) {
            throw new ServiceException(ErrorCode.SYS_ERROR);
        }
        else if (record > 0) {
            return 1;
        }
        return 0;
    }

    @Override
	public int delEducationPlan(Integer educationPlanId) throws Exception {

        int record = educationPlanDao.delEducationPlan(educationPlanId);
        return record;
    }

    @Override
	public Education getEducationById(Integer educationPlanId) throws Exception {
		// TODO Auto-generated method stub
        Education education = educationPlanDao.queryEducationId(educationPlanId);
        return education;
    }

	/*@Override
	public PageInfo<Education> queryMajorName(String majorName, Integer pageNo, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 3 : pageSize;
		// 开启分页 参数为当前页和数据条数
		PageHelper.startPage(pageNo, pageSize);
		// 查询结果返回
		List<Education> edList = educationPlanDao.queryMajorName(majorName);
		PageInfo<Education> page = new PageInfo<Education>(edList);
		return page;
	}

	@Override
	public Education queryCoueseName(Integer educationPlanId) throws Exception {

		// 查询结果返回
		Education education = educationPlanDao.queryCoueseNameList(educationPlanId);
		return education;
	}*/

    @Transactional
	@Override
	public int updataEducationPlan(Education education) throws Exception {
		// TODO Auto-generated method stub
        int record = educationPlanDao.updataEducationPlan(education);
        if (record < 0) {
            throw new ServiceException(ErrorCode.SYS_ERROR);
        }
        else if (record > 0) {
            return 1;
        }
        return 0;
    }

    @Override
	public List<MajorModel> addMajorPlan() throws Exception {
		// TODO Auto-generated method stub
        List<MajorModel> mm=educationPlanDao.addMajorPlan();
        return mm;
    }

    @Override
	public List<Education> queryPlan() throws Exception {
		// TODO Auto-generated method stub
        List<Education> edList=educationPlanDao.queryPlan();
        return edList;
    }

}
