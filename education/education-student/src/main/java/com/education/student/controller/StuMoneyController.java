package com.education.student.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.SynthesizedAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.StudentModel;
import com.education.service.IStuMoneyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 学生缴费状态控制层
 * 
 * @author 李梦鸽
 *
 */
@Api(value = "api/student", description = "学生端缴费信息的相关操作")
@RequestMapping("api/student")
@Controller
public class StuMoneyController {
	/**
	 * 学生缴费状态依赖注入IStuMoneyService
	 */
	@Reference
	private IStuMoneyService sms;

	/**
	 * 根据学生编号查看缴费状态
	 * 
	 * @param studentId
	 *            学生编号
	 * @return ResultDo<Object> 
	 *            统一返回对象
	 * @throws Exception
	 *            异常抛出，交给全局异常处理器
	 */
	@ApiOperation(notes = "getMoney", httpMethod = "GET", value = "根据学生编号查看缴费信息")
	@RequestMapping(value = "StuMoneyController/getMoney", method = RequestMethod.GET)
	@ResponseBody
	public ResultDo<Object> payMoney(HttpSession session) throws Exception {
		List<StudentModel> getMoney = sms.getMoney(Integer.parseInt(session.getAttribute("stuId").toString()));
		System.out.println("控制层"+Integer.parseInt(session.getAttribute("stuId").toString()));
		ResultDo<Object> rs = new ResultDo<Object>();
		rs.setResData(getMoney);
		return rs;
	}

	/**
	 * 根据身份证交费
	 * 
	 * @param studentIdcard
	 *            身份证
	 * @return ResultDo<Object> 
	 *            统一返回对象
	 * @throws Exception
	 *            异常抛出，交给全局异常处理器
	 */
	@ApiOperation(notes = "payMoney", httpMethod = "GET", value = "学生根据身份证缴费")
	@RequestMapping(value = "StuMoneyController/payMoney", method = RequestMethod.GET)
	@ResponseBody
	public ResultDo<Object> payMoney(String studentIdcard) throws Exception {
		StudentModel payMoney = sms.payMoney(studentIdcard);
		ResultDo<Object> rs = new ResultDo<Object>();
		rs.setResData(payMoney);
		return rs;
	}

	/**
	 * 学生缴费
	 * 
	 * @param StudentModel
	 *            学生
	 * @return ResultDo<Object> 
	 *            统一返回对象
	 * @throws Exception
	 *            异常抛出，交给全局异常处理器
	 */
	@ApiOperation(notes = "updateMoney", httpMethod = "POST", value = "学生缴费")
	@RequestMapping(value = "StuMoneyController/updateMoney", method = RequestMethod.POST)
	@ResponseBody
	public ResultDo<Object> updateMoney(@RequestBody StudentModel studentModel) throws Exception {
		int updateMoney = sms.updateMoney(studentModel);
		ResultDo<Object> rs = new ResultDo<Object>();
		rs.setResData(updateMoney);
		return rs;
	}
}
