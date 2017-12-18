package com.education.student.controller;

import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.TransactionModel;
import com.education.service.IChangeService;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author xyh
 * @param <T>
 *
 */
@Api(value = "/api/teacher/change", description = "异动申请")
@Controller
@RequestMapping("/api/teacher/change")
public class SChangeController<T> {
	/**
	 * 日志记录文件
	 */
	private static Logger LOGGER = LogManager.getLogger(SChangeController.class.getName());

	/**
	 * 注入业务层接口
	 */
	@Reference
	private IChangeService cs;

	/**
	 * 获取该生所有异动列表
	 * 
	 * @param studentId
	 *            学生编号
	 * @param pageNo
	 *            分页
	 * @param pageSize
	 *            分页
	 * @return list
	 * @throws Exception
	 *             异常
	 */
	@ApiOperation(notes = "query2", httpMethod = "GET", value = "获取该生所有异动列表")
	@RequestMapping(value = "/query2", method = RequestMethod.GET)
	@ResponseBody
	public ResultDo<Object> queryTranById() throws Exception {
		PageInfo<TransactionModel> page = cs.queryTranById(1, 1, 6);
		System.out.println("3333333333333");

		System.out.println(page.getList().size());
		ResultDo<Object> res = new ResultDo<Object>();
		if (page.getList().size() > 0) {
			res.setResCode(0);
			res.setResMsg("请求成功");
			res.setResData(page);
		} else {
			res.setResCode(-1);
			res.setResMsg("请求失败");
		}
		System.out.println("c3");
		LOGGER.info(res);
		return res;
	}

	@ApiOperation(notes = "addChange", httpMethod = "POST", value = "增加学生异动")
	@RequestMapping(value = "/addChange", method = RequestMethod.POST)
	@ResponseBody
	public ResultDo<Object> addChange(@RequestBody TransactionModel tm, HttpSession session) throws Exception {
		
		session.setAttribute("studentId", 1);
		Integer rs = (Integer) session.getAttribute("studentId");
		tm.setStudentId(rs);
		
		System.out.println(tm.getStudentId());
		System.out.println("111111111");
		int result = cs.addChange(tm);
		ResultDo<Object> res = new ResultDo<Object>();
		if (result > 0) {
			res.setResCode(0);
			res.setResMsg("增加成功");
		}
		return res;

	}

}
