package com.education.service;

import com.education.model.Education;
import com.github.pagehelper.PageInfo;

/**
 * 用户服务层接口
 * @author 徐大仁
 *
 */
public interface EducationService {
	/**
	    *@param pageNo 当前页
	    *@param pageSize 总数据条数
	    *@return PageInfo<User> 分页实体
	    *@throws Exception 业务处理层异常
	    */
    PageInfo<Education> queryByPage(Integer pageNo, Integer pageSize) throws Exception;
}
