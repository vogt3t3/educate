package com.education.service;

import java.util.List;

import com.education.model.Education;
import com.education.model.MajorModel;
import com.github.pagehelper.PageInfo;

/**
 * 用户服务层接口
 * @author 徐大仁
 *
 */
public interface EdService {
	/**
	 * @param pageNo 当前页
	 * @param pageSize 总数据条数
	 * @param educationPlanId Integer
	 * @param majorName String
	 * @return PageInfo<User> 分页实体
	 * @throws Exception
	 *             业务处理层异常
	 */
    PageInfo<Education> queryByPage(Integer educationPlanId,String majorName,Integer pageNo, Integer pageSize) throws Exception;

//	/**
//	 * 模糊查询分页教学计划表(教师端(计划号))
//	 * 
//	 * @return List<CourseModel>
//	 * @throws Exception
//	 *             gg
//	 */
//	Education queryCoueseName(Integer educationPlanId) throws Exception;
//
//	/**
//	 * 模糊查询分页教学计划表(教师端(专业))
//	 * 
//	 * @return List<MajorModel>
//	 * @throws Exception
//	 *             gg
//	 */
//	PageInfo<Education> queryMajorName(String majorName, Integer pageNo, Integer pageSize) throws Exception;

	/**
	 * 增加教学计划(教师端)
	 * @param educationPlanId Integer
	 * @return Education
	 * @throws Exception
	 *             GG
	 */
    Education getEducationById(Integer educationPlanId) throws Exception;

	/**
	 * 更新教学计划表(教师端)
	 * 
	 * @param education
	 *            Education
	 * @return int
	 * @throws Exception
	 *             gg
	 */
    int updataEducationPlan(Education education) throws Exception;

	/**
	 * 删除(隐藏)教学计划表(教师端)
	 * @param educationPlanId Integer
	 * @return int
	 * @throws Exception gg
	 */
    int delEducationPlan(Integer educationPlanId) throws Exception;

	/**
	 * 增加一条计划
	 * @param education Education
	 * @return int
	 * @throws Exception gg
	 */
    int addEducationPlan(Education education) throws Exception;
	
	/**
	 * 增加教学计划(教师端)
	 * @return List<Education>
	 * @throws Exception GG
	 */
    List<Education> queryPlan() throws Exception;
	/**
	 * 增加教学计划(教师端)
	 * @return List<MajorModel>
	 * @throws Exception GG
	 */
    List<MajorModel> addMajorPlan() throws Exception;
}
