package com.education.teacher.controller;


import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.StudentEnterModel;
import com.education.service.IAdmissionsRevie;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author 张露林招生人员的审核部分
 *
 */
@Api(value = "/api/teacher", description = "报名审核")
@Controller
@RequestMapping("/api/teacher")
public class AdmissionsAuditController {
	
	@Reference
	private IAdmissionsRevie admissions;
	/**
     * 引入log4j日志记录
     */
/*    private static Logger logger = Logger.getLogger(MajorContoroller.class.getName());*/
    /**
	 * @return String
	 * @author 预留审核人员的审核
	 */
	@ApiOperation(notes = "/check/queryStudentCheck", httpMethod = "GET", value = "审核人员的审核学生")
    @RequestMapping("/check/queryStudentCheck")
	@ResponseBody
    public ResultDo<PageInfo<StudentEnterModel>> selectStuDetailCheck(Integer currentPage, Integer pageSize) throws Exception{
    	//获取从前台传来的数据
		ResultDo<PageInfo<StudentEnterModel>> res = admissions.selectDentCheck(currentPage,pageSize);
    	return res;
    }
	
	/**
	 * @return String
	 * @author 审核人员的审核学生
	 */
	@ApiOperation(notes = "/check/queryStudent", httpMethod = "GET", value = "审核人员的审核学生")
    @RequestMapping("/check/queryStudent")
	@ResponseBody
    public ResultDo<PageInfo<StudentEnterModel>> selectStuDetail(Integer currentPage, Integer pageSize) throws Exception{
    	//获取从前台传来的数据
		ResultDo<PageInfo<StudentEnterModel>> res = admissions.selectStudent(currentPage,pageSize);
		return res;
    }
	/**
	 * @return String
	 * @author 审核人员的审核学生详情(根据id)
	 */
	@ApiOperation(notes = "/check/queryStudentMessage", httpMethod = "GET", value = "审核人员的审核学生详情(根据id)")
    @RequestMapping("/check/queryStudentMessage")
	@ResponseBody
	public ResultDo<StudentEnterModel> selectStuDetail(Integer enterId) throws Exception{
		ResultDo<StudentEnterModel> res = admissions.selectStudentDetail(enterId);
		return res;
	}
	/**
	 * @return String
	 * @author 审核人员的审核(根据id修改审核状态)
	 */
	@ApiOperation(notes = "/check/updateStudent", httpMethod = "GET", value = "审核人员的审核学生详情(根据id)")
    @RequestMapping("/check/updateStudent")
	@ResponseBody
	public int updateStudent(Integer enterId,Integer enterCheckState) throws Exception{
		int res = admissions.updateStudentStu(enterId, enterCheckState);
		return res;
	}
	/**
	 * @return String
	 * @author 审核部分的缴费
	 */
	@ApiOperation(notes = "/check/queryMoney", httpMethod = "GET", value = "审核部分的缴费")
    @RequestMapping("/check/queryMoney")
	@ResponseBody
    public ResultDo<PageInfo<StudentEnterModel>> selectMon(Integer currentPage, Integer pageSize) throws Exception{
    	//获取从前台传来的数据
		ResultDo<PageInfo<StudentEnterModel>> res = admissions.selectMoney(currentPage, pageSize);
    	return res;
    }
	/**
	 * @return String
	 * @author 审核部分的缴费详情(根据id)
	 */
	@ApiOperation(notes = "/check/queryMoneyMessage", httpMethod = "GET", value = "审核部分的缴费详情(根据id)")
    @RequestMapping("/check/queryMoneyMessage")
	@ResponseBody
	public ResultDo<StudentEnterModel> selectMonDetail(Integer enterId) throws Exception{
		ResultDo<StudentEnterModel> res = admissions.selectMoneyDetail(enterId);
		return res;
	}
	/**
	 * @return String
	 * @author 审核部分的入学成绩
	 */
	@ApiOperation(notes = "/check/queryGrade", httpMethod = "GET", value = "审核部分的入学成绩")
    @RequestMapping("/check/queryGrade")
	@ResponseBody
    public ResultDo<PageInfo<StudentEnterModel>> selectSco(Integer currentPage,Integer pageSize) throws Exception{
    	//获取从前台传来的数据
		ResultDo<PageInfo<StudentEnterModel>> res = admissions.selectScore(currentPage, pageSize);
    	return res;
    }
	/**
	 * @return String
	 * @author 审核部分的入学成绩详情(根据id)
	 */
	@ApiOperation(notes = "/check/queryGradeMessage", httpMethod = "GET", value = "审核部分的入学成绩详情(根据id)")
    @RequestMapping("/check/queryGradeMessage")
	@ResponseBody
	public ResultDo<StudentEnterModel> selectScoDetail(Integer enterId) throws Exception{
		ResultDo<StudentEnterModel> res = admissions.selectScoreDetail(enterId);
		return res;
	}
	/**
	 * @return String
	 * @author 审核部分的历史记录
	 */
	@ApiOperation(notes = "/check/queryHistorical", httpMethod = "GET", value = "审核部分的历史记录")
    @RequestMapping("/check/queryHistorical")
	@ResponseBody
    public ResultDo<PageInfo<StudentEnterModel>> selectHist(Integer currentPage, Integer pageSize) throws Exception{
    	//获取从前台传来的数据
		ResultDo<PageInfo<StudentEnterModel>> res = admissions.selectHistorical(currentPage, pageSize);
    	return res;
    }
	/**
	 * @return String
	 * @author 审核部分的历史记录详情(根据id)
	 */
	@ApiOperation(notes = "/check/queryHistoricalMessage", httpMethod = "GET", value = "审核部分的历史记录详情(根据id)")
    @RequestMapping("/check/queryHistoricalMessage")
	@ResponseBody
	public ResultDo<StudentEnterModel> selectHistDetail(Integer enterId) throws Exception{
		ResultDo<StudentEnterModel> res = admissions.selectHistoricalDetail(enterId);
		return res;
	}
}
