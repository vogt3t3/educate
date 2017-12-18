package com.education.teacher.controller;

import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.StudentModel;
import com.education.model.StudentModelDate;
import com.education.service.IStucostSercive;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 学费管理控制层实例
 * 
 * @author 周长磊
 *
 */
@Api(value = "/api/teacher/admin")
@RestController
@RequestMapping("/api/teacher/admin")
public class StucostController {

    /**
     * 日志记录类
     */
    private static Logger LOGGER = LogManager.getLogger(StucostController.class.getName());

    /**
     * 注入用户业务处理接口
     */
    @Reference
    private IStucostSercive istucostSercive;

    /**
     * 查询学费信息（分页查询 + 模糊查询）
     * 
     * @param stu
     *            学费管理多条件查询实体
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return ResultDo<Object>
     * @throws Exception
     *             业务处理层异常
     */
    @ApiOperation(notes = "Studentcostmanage", httpMethod = "GET", value = "查询学费信息（分页查询 + 模糊查询）")
    @RequestMapping(value = "/Studentcostmanage", method = RequestMethod.GET)
    public ResultDo<Object> listStucostBy(StudentModelDate stu, Integer pageNo, Integer pageSize) throws Exception {

        // 返回查询结果
        PageInfo<StudentModel> pageInfo = istucostSercive.listStucostBy(stu, pageNo, pageSize);

        // 将查询结果传给ResultDo对象
        ResultDo<Object> rs = new ResultDo<Object>();
        if (pageInfo.getList().size() > 0) {
            rs.setResData(pageInfo);
            rs.setResCode(0); // 返回状态码
            rs.setResMsg("请求成功");
        } else {
            rs.setResCode(-1);
            rs.setResMsg("没有该数据");
        }
        LOGGER.info(rs);

        return rs;
    }

    /**
     * 未交学费【以现在时间减去入校时间算出应该交的学费】（人）
     * 
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return PageInfo<StudentModel> 分页实体
     * @throws Exception
     *             抛出异常
     */
    @ApiOperation(notes = "Studentcostmanagewj", httpMethod = "GET", value = "未交学费【以现在时间减去入校时间算出应该交的学费】（人）")
    @RequestMapping(value = "/Studentcostmanagewj", method = RequestMethod.GET)
    public ResultDo<Object> listStucostUnpaid(Integer pageNo, Integer pageSize) throws Exception {

        // 返回查询结果
        PageInfo<StudentModel> pageInfo = istucostSercive.listStucostUnpaid(pageNo, pageSize);

        // 将查询结果传给ResultDo对象
        ResultDo<Object> rs = new ResultDo<Object>();
        if (pageInfo.getList().size() > 0) {
            rs.setResData(pageInfo);
            rs.setResCode(0); // 返回状态码
            rs.setResMsg("请求成功");
        } else {
            rs.setResCode(-1);
            rs.setResMsg("没有该数据");
        }
        LOGGER.info(rs);

        return rs;
    }

    /**
     * 更新学费记录（按学生编号）
     * 
     * @param stu
     *            学生表实体
     * @param session 获取session
     * @return int
     * @throws Exception
     *             抛出异常
     */
    @ApiOperation(notes = "Studentcostmanageup", httpMethod = "POST", value = "未交学费【以现在时间减去入校时间算出应该交的学费】（人）")
    @RequestMapping(value = "/Studentcostmanageup", method = RequestMethod.POST)
    public ResultDo<Object> updateStucostById(@RequestBody StudentModel stu, HttpSession session) throws Exception {

        // 获取当前用户名称
        stu.setModifyPerson((String) session.getAttribute("teacherId"));

        // 返回查询结果
        int record = istucostSercive.updateStucostById(stu);

        // 将查询结果传给ResultDo对象
        ResultDo<Object> rs = new ResultDo<Object>();
        if (record > 0) {
            rs.setResData(record);
            rs.setResCode(0); // 返回状态码
            rs.setResMsg("修改成功");
        } else {
            rs.setResCode(-1);
            rs.setResMsg("修改失败");
        }
        LOGGER.info(rs);

        return rs;
    }

}
