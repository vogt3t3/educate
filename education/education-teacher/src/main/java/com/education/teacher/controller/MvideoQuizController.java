package com.education.teacher.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.StudentQuizModel;
import com.education.service.MvideoQuizService;
import com.github.pagehelper.PageInfo;

/**
 * @author 视频答疑问题
 *
 */
@Controller
public class MvideoQuizController {
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(ExamMessageController.class.getName());
    /**
     * 调用服务类方法
     */
    @Reference
    private MvideoQuizService ms;

    /**
     * @param pageNo
     *            前台页面传入当前页
     * @param pageSize
     *            前台页面传入一页多少数据
     * @return 返回视频分页集合
     * @throws Exception
     *             向上抛出异常
     */
    @RequestMapping(path = "/api/master/addVideoQuiz", method = RequestMethod.GET)
    @ResponseBody
    public ResultDo<PageInfo<StudentQuizModel>> seleVideoQuiz(@RequestParam("pageNum") Integer pageNo, Integer pageSize) throws Exception {
       /* System.out.println(pageNo);
        System.out.println(pageSize);*/
        PageInfo<StudentQuizModel> pro = ms.mvpage(pageNo, pageSize);
        ResultDo<PageInfo<StudentQuizModel>> resultDo = new ResultDo<PageInfo<StudentQuizModel>>();
        resultDo.setResCode(0);
        resultDo.setResMsg("请求成功");
        resultDo.setResData(pro);
        return resultDo;
    }
    /**
     * @param name
     *            返回姓名
     * 
     * @param lx
     *            返回lx
     * @return 查询分页
     * @throws Exception
     *             抛出异常
     */
    @RequestMapping(path = "/api/master/seleVideoQuiz", method = RequestMethod.GET)
    @ResponseBody
    public ResultDo<PageInfo<StudentQuizModel>> seleVideoQuiz(String name, Integer lx) throws Exception {
        PageInfo<StudentQuizModel> pro1 = ms.mhone(name, lx, 1, 5);
        System.out.println("%" + name + "%");
        ResultDo<PageInfo<StudentQuizModel>> resultDo = new ResultDo<PageInfo<StudentQuizModel>>();
        resultDo.setResCode(0);
        resultDo.setResMsg("请求成功");
        resultDo.setResData(pro1);
        return resultDo;
    }

    /**
     * @param map 传入的回复
     * @return 查询分页
     * @throws Exception
     *             抛出异常
     */
    @RequestMapping(path = "/api/master/updateVideoQuiz",method = RequestMethod.POST)
    @ResponseBody
    public int replyVideoQuiz(@RequestBody Map<String,Object> map) throws Exception {
        ms.updateVideoQuiz((Integer)map.get("teid"),(Integer)map.get("quid"),(Integer)map.get("reid"),(String)map.get("reco"));
        return 1222;
    }
    /**
     * @param map1 返回的I的
     * @return 返回成功
     * @throws Exception 向上抛出异常
     */
    @RequestMapping(path = "/api/master/delvideo",method = RequestMethod.POST)
    @ResponseBody
    public int deleVideo(@RequestBody Map<String,Object> map1) throws Exception {
        System.out.println("-----------"+(Integer)map1.get("quizId"));
        ms.delevoide((Integer)map1.get("quizId"));
        return 1222;
    }

}
