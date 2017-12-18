package com.education.teacher.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.TransactionModel;
import com.education.service.IChangeService;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 异动管理
 * 
 * @author xyh
 *
 */
@Api(value = "/api/teacher/change", description = "异动管理")
@Controller
@RequestMapping("/api/teacher/change")
public class TChangeController {

	/**
	 * 日志记录文件
	 */
    private static Logger LOGGER = LogManager.getLogger(TChangeController.class.getName());

	/**
	 * 注入业务层接口
	 */
    @Reference
	private IChangeService ichangeService;

	/**
	 * 教师端获取所有异动列表
	 * 
	 * @param studentId
	 *            学生编号
	 * @param studentName
	 *            学生姓名
	 * @param pageNo
	 *            分页
	 * @param pageSize
	 *            分页
	 * @return 集合
	 */
    @ApiOperation(notes = "query", httpMethod = "GET", value = "获取所有异动列表")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public ResultDo<Object> queryChange(Integer studentId, String studentName, Integer pageNo, Integer pageSize) {

		// 获取查询值
        PageInfo<TransactionModel> page = null;
        try {
            page = ichangeService.queryByPage(studentId, studentName, pageNo, pageSize);
        } 
        catch (Exception e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(page.getList().size());

		// 将查询的值赋值给ResultDo
        ResultDo<Object> res = new ResultDo<Object>();
        if (page.getList().size() > 0) {
            res.setResCode(0);
            res.setResMsg("请求成功");
            res.setResData(page);
        } 
        else {
            res.setResCode(-1);
            res.setResMsg("请求失败");
        }
        System.out.println("c3");
        LOGGER.info(res);
        return res;
    }

	/**
	 * 教师端删除异动
	 * 
	 * @param transactionId
	 *            异动编号
	 * @return 泛型
	 * @throws Exception
	 *             抛出异常
	 */
    @ApiOperation(notes = "remove", httpMethod = "GET", value = "删除异动")
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	@ResponseBody
	public ResultDo<Object> delChange(@RequestParam("transactionId") Integer transactionId) throws Exception {
        System.out.println("1111111");
        int result = ichangeService.deleteChange(transactionId);
        System.out.println("9999");
        ResultDo<Object> res = new ResultDo<Object>();
        if (result > 0) {
            res.setResCode(0);
            res.setResMsg("删除成功");
        }
        return res;

    }

	/**
	 * 教师端更新异动
	 * 
	 * @param tm
	 *            异动实体类
	 * @return 泛型
	 * @throws Exception
	 *             抛出异常
	 */
    @ApiOperation(notes = "edit", httpMethod = "POST", value = "修改异动")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public ResultDo<Object> updateChange(@RequestBody TransactionModel tm) throws Exception {
        int count = ichangeService.updateChange(tm);
        ResultDo<Object> res = new ResultDo<Object>();
        if (count > 0) {
            res.setResCode(0);
            res.setResMsg("修改成功");
        }
        return res;

    }
}
