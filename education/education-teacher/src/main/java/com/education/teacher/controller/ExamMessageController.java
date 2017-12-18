package com.education.teacher.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ExamMessageModel;
import com.education.model.ResultDo;
import com.education.service.QueryExamPage;
import com.github.pagehelper.PageInfo;

/**
 * @author 考试信息表
 *
 */
@Controller
public class ExamMessageController {
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(ExamMessageController.class.getName());
    /**
     * 调用服务类方法
     */
    @Reference
    private QueryExamPage qp;

    /**
     *  导入实体类
     */
    private ExamMessageModel el;

    /**
     * 注入添加考试信息
     */

    /**
     * @return 分页集合
     * @throws Exception
     *             返回错误
     * @param pageSize
     *            当前一页有多少数据
     * @param pageNo
     *            当前有多少页
     * @throws Exception
     *             向上抛出异常
     */
    @RequestMapping(path = "/api/master/queryExam", method = RequestMethod.GET)
    @ResponseBody
    public ResultDo<Object> queryExam(Integer pageNo, Integer pageSize) throws Exception {
        System.out.println("---");
        PageInfo<ExamMessageModel> pro = qp.pagenow(pageNo, pageSize);
        List<ExamMessageModel> st = pro.getList();
        for (ExamMessageModel el : st) {
            System.out.println(el.getExamappointtimestr());

        }
        ResultDo<Object> resultDo = new ResultDo<Object>();
        System.out.println(resultDo);
        resultDo.setResCode(0);
        resultDo.setResMsg("请求成功");
        resultDo.setResData(pro);
        return resultDo;
    }

    /**
     * 
     * @param el
     *            传进来增加的值
     * @throws Exception
     *             抛出异常
     */
    @RequestMapping(path = "/api/master/addExam", method = RequestMethod.POST)
    @ResponseBody
    public void addExam(@RequestBody ExamMessageModel el) throws Exception {
        qp.addexam(el);
    }
    /**
     * @param map 输入ID号
     * @return 返回是否成功
     * @throws Exception 向上抛出异常
     */
    @RequestMapping(path = "/api/master/delExam", method = RequestMethod.POST)
    @ResponseBody
    public  int  deleExam(@RequestBody Map<String,Object> map)throws Exception {
        System.out.println("--------------"+(Integer)map.get("examid")+"--");
        qp.deleup((Integer)map.get("examid"));
        return 1;
    }
    
}
