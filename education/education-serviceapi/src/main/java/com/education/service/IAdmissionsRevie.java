package com.education.service;

import com.education.model.ResultDo;
import com.education.model.StudentEnterModel;
import com.github.pagehelper.PageInfo;
/**
 * @author 张露林招生人员的审核部分服务层接口
 */
public interface IAdmissionsRevie {
	/**
	 * 审核人员的审核学生查询
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<List<StudentEnterModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	 ResultDo<PageInfo<StudentEnterModel>> selectDentCheck(int pageNum, int pageSize) throws Exception;
	/**
	 * 审核部分的审核学生
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<List<StudentEnterModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	 ResultDo<PageInfo<StudentEnterModel>> selectStudent(int pageNum, int pageSize) throws Exception;
	/**
	 * 审核部分的审核学生详情
     *@return ResultDo<StudentEnterModel> 
     *@throws Exception 业务处理层异常
     */
	ResultDo<StudentEnterModel> selectStudentDetail(int enterId) throws Exception;
	/**
	 * 审核人员的审核(根据id修改审核状态)
     *@return int 
     *@throws Exception 业务处理层异常
     */
	 int updateStudentStu(int enterId, int enterCheckState);
	/**
	 * 审核部分的缴费
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<List<StudentEnterModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	ResultDo<PageInfo<StudentEnterModel>> selectMoney(int pageNum, int pageSize) throws Exception;
	/**
	 * 审核部分的缴费详情
     *@return ResultDo<StudentEnterModel> 
     *@throws Exception 业务处理层异常
     */
	ResultDo<StudentEnterModel> selectMoneyDetail(int enterId) throws Exception;
	/**
	 * 审核部分的入学成绩
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<List<StudentEnterModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	ResultDo<PageInfo<StudentEnterModel>> selectScore(int pageNum, int pageSize) throws Exception;
	/**
	 * 审核部分的入学成绩详情
     *@return ResultDo<StudentEnterModel> 
     *@throws Exception 业务处理层异常
     */
	ResultDo<StudentEnterModel> selectScoreDetail(int enterId) throws Exception;
	/**
	 * 审核部分的历史记录
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<List<StudentEnterModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	ResultDo<PageInfo<StudentEnterModel>> selectHistorical(int pageNum, int pageSize) throws Exception;
	/**
	 * 审核部分的历史记录详情
     *@return ResultDo<StudentEnterModel> 
     *@throws Exception 业务处理层异常
     */
	ResultDo<StudentEnterModel> selectHistoricalDetail(int enterId) throws Exception;
}
