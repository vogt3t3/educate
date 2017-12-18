package com.education.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.education.model.Education;
import com.education.model.MajorModel;

/**
 * @author 徐大仁
 *
 */
public interface EducationPlanDao {
	/**
	 * 查询分页教学计划表(学生端)
	 * 
	 * @return List<Education>
	 * @throws Exception
	 *             抛出数据层异常
	 */
    List<Education> listEducation() throws Exception;

	/**
	 * 查询分页教学计划表(教师端)
	 * @param educationPlanId Integer
     * @param majorName String
	 * @return List<Education>
	 * @throws Exception dd
	 */
    List<Education> queryEducationPlan(@Param("educationPlanId") Integer educationPlanId,@Param("majorName") String majorName) throws Exception;

//	/**
//	 * 模糊查询分页教学计划表(教师端(计划号))
//	 * 
//	 * @return List<CourseModel>
//	 * @throws Exception
//	 *             gg
//	 */
//	Education queryCoueseNameList(@Param("educationPlanId") Integer educationPlanId) throws Exception;
//
//	/**
//	 * 模糊查询分页教学计划表(教师端(专业))
//	 * 
//	 * @return List<MajorModel>
//	 * @throws Exception
//	 *             gg
//	 */
//	List<Education> queryMajorName(@Param("majorName") String majorName) throws Exception;

	/**
	 * 增加教学计划(教师端)
	 * 
	 * @param education
	 *            Education
	 * @return int
	 * @throws Exception
	 *             GG
	 */
    int addEducationPlan(Education education) throws Exception;

	/**
	 * 增加教学计划(教师端)
	 * @return int
	 * @throws Exception
	 *             GG
	 */ 
    List<Education> queryPlan() throws Exception;
	/**
	 * 增加教学计划(教师端)
	 * @return int
	 * @throws Exception
	 *             GG
	 */
    List<MajorModel> addMajorPlan() throws Exception;

	/**
	 * 删除(隐藏)教学计划(教师端)
	 * 
	 * @param educationPlanId
	 *            int
	 * @return int
	 * @throws Exception
	 *             gg
	 */
    int delEducationPlan(@Param("educationPlanId") Integer educationPlanId) throws Exception;

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
	 * 根据id查询一条数据(教师端)
	 * 
	 * @param educationPlanId
	 *            Integer
	 * @return Education
	 * @throws Exception
	 *             gg
	 */
    Education queryEducationId(@Param("educationPlanId") Integer educationPlanId) throws Exception;

}
