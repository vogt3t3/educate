package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.CpersonDao;
import com.education.model.ResultDo;
import com.education.model.StudentEnterModel;
import com.education.service.IAdmissionsRevie;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @author 张露林招生人员的审核部分接口的实现(服务层)
 */
@Service
public class AdmissionsReviewimpl implements IAdmissionsRevie {
	/**
     * 注入审核人员的数据层接口 CpersonDao
     */
	 @Autowired
	 private CpersonDao cpersonDao;
	 /**
	  * 注入把报名表复制到学生表的数据层接口 CpersonDao
	  */
	/* @Autowired
	 private EnterCopyStudent copy;*/
	 /**
	  * 预留部分招生人员审核
		*@param pageNum 当前页
		*@param pageSize 当前页的数量
		*@return ResultDo<List<StudentEnterModel>> 分页实体
		*@throws Exception 业务处理层异常
		*/
	public ResultDo<PageInfo<StudentEnterModel>> selectDentCheck(int currentPage, int pageSize) throws Exception{
		PageHelper.startPage(currentPage, pageSize);
	    List<StudentEnterModel> list = cpersonDao.queryDentCheck();
	    PageInfo<StudentEnterModel> PageBean = new PageInfo<StudentEnterModel>(list);
	    ResultDo<PageInfo<StudentEnterModel>> res = new ResultDo<PageInfo<StudentEnterModel>>();
		res.setResData(PageBean);
	    return res;
		}
		
	/**
	 *  审核部分的审核学生
	*@param pageNum 当前页
	*@param pageSize 当前页的数量
	*@return ResultDo<List<StudentEnterModel>> 分页实体
	*@throws Exception 业务处理层异常
	*/
	public  ResultDo<PageInfo<StudentEnterModel>> selectStudent(int pageNum, int pageSize) throws Exception{
		PageHelper.startPage(pageNum, pageSize);
        List<StudentEnterModel> list = this.cpersonDao.queryStudent();
        PageInfo<StudentEnterModel> PageBean = new PageInfo<StudentEnterModel>(list);
        ResultDo<PageInfo<StudentEnterModel>> res = new ResultDo<PageInfo<StudentEnterModel>>();
		res.setResData(PageBean);
        return res;
	}
	/**
	 * 审核部分的审核学生详情
     *@return ResultDo<StudentEnterModel> 分页实体 
     *@throws Exception 业务处理层异常
     */
	@Override
	public ResultDo<StudentEnterModel> selectStudentDetail(int enterId) throws Exception {
		// TODO Auto-generated method stub
		StudentEnterModel  student= cpersonDao.queryStudentDetails(enterId);
		ResultDo<StudentEnterModel> ress = new ResultDo<StudentEnterModel>();
		ress.setResData(student);
		return ress;
	}
	/**
	 * 审核人员的审核(根据id修改审核状态)
     *@return ResultDo<StudentEnterModel> 分页实体 
     *@throws Exception 业务处理层异常
     */
	public int updateStudentStu(int enterId, int enterCheckState){
		int ress = cpersonDao.updateStudent(enterId, enterCheckState);
		return ress;
	}
	/**
	 * 审核部分的缴费
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<List<StudentEnterModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	@Override
	public ResultDo<PageInfo<StudentEnterModel>> selectMoney(int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
        List<StudentEnterModel> list = this.cpersonDao.queryMoney();
        PageInfo<StudentEnterModel> PageBean = new PageInfo<StudentEnterModel>(list);
        ResultDo<PageInfo<StudentEnterModel>> res = new ResultDo<PageInfo<StudentEnterModel>>();
		res.setResData(PageBean);
		return res;
	}
	/**
	 * 审核部分的缴费详情
     *@return ResultDo<StudentEnterModel> 
     *@throws Exception 业务处理层异常
     */
	@Override
	public ResultDo<StudentEnterModel> selectMoneyDetail(int enterId) throws Exception {
		// TODO Auto-generated method stub
		StudentEnterModel  student= cpersonDao.queryMoneyDetails(enterId);
		ResultDo<StudentEnterModel> ressm = new ResultDo<StudentEnterModel>();
		ressm.setResData(student);
		return ressm;
	}
	/**
	 * 审核部分的入学成绩
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<List<StudentEnterModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	@Override
	public ResultDo<PageInfo<StudentEnterModel>> selectScore(int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
        List<StudentEnterModel> list = this.cpersonDao.queryGrade();
        PageInfo<StudentEnterModel> PageBean = new PageInfo<StudentEnterModel>(list);
        ResultDo<PageInfo<StudentEnterModel>> res = new ResultDo<PageInfo<StudentEnterModel>>();
		res.setResData(PageBean);
		return res;
	}
	/**
	 * 审核部分的入学成绩
     *@return ResultDo<StudentEnterModel> 
     *@throws Exception 业务处理层异常
     */
	@Override
	public ResultDo<StudentEnterModel> selectScoreDetail(int enterId) throws Exception {
		// TODO Auto-generated method stub
		StudentEnterModel  student= cpersonDao.queryGradeDetails(enterId);
		ResultDo<StudentEnterModel> ressg = new ResultDo<StudentEnterModel>();
		ressg.setResData(student);
		return ressg;
	}
	/**
	 * 审核部分的历史记录
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<List<StudentEnterModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	@Override
	public ResultDo<PageInfo<StudentEnterModel>> selectHistorical(int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
        List<StudentEnterModel> list = this.cpersonDao.queryHistorical();
        PageInfo<StudentEnterModel> PageBean = new PageInfo<StudentEnterModel>(list);
        ResultDo<PageInfo<StudentEnterModel>> res = new ResultDo<PageInfo<StudentEnterModel>>();
		res.setResData(PageBean);
		return res;
	}
	/**
	 * 审核部分的历史记录
     *@return ResultDo<StudentEnterModel> 
     *@throws Exception 业务处理层异常
     */
	@Override
	public ResultDo<StudentEnterModel> selectHistoricalDetail(int enterId) throws Exception {
		// TODO Auto-generated method stub
		StudentEnterModel  student= cpersonDao.queryHistoricalDetails1(enterId);
		ResultDo<StudentEnterModel> ressh = new ResultDo<StudentEnterModel>();
		ressh.setResData(student);
		return ressh;
	}
}
