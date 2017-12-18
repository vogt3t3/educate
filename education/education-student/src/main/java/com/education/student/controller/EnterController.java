package com.education.student.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.StudentEnterModel;
import com.education.service.IEnterService;

/**
 * 报名模块的控制层 该模块是对学生报名模块
 * 
 * @author 张建磊
 */
@Controller
@RequestMapping("/api")
public class EnterController {
    /**
     * 注入导学资源的业务层
     */
    @Reference
    private IEnterService ienter;
    /**
     * 引入log4j日志记录
     */
    private static Logger logger = Logger.getLogger(EnterController.class.getName());

    /**
     * @param file
     *            报名信息
     * @param session
     * @return StudentEnterModel student,@RequestParam(value="file")
     *         MultipartFile file,HttpSession session
     * @throws Exception
     *             默认加载 加载一个信息
     */
    @RequestMapping("/addstuaaa")
    @ResponseBody
    public StudentEnterModel quert(HttpSession session) throws Exception {
        int enterId = 11;
        StudentEnterModel result = ienter.quertstusss(enterId);
        return result;
    }

    /**
     * @param enterIdcard
     *            身份证号
     * @param enterPayMoney
     *            缴费金额
     * @param enterPayWay1
     *            缴费方式
     * @param session
     * @return
     * @throws Exception
     *             抛出异常 缴费后 把报名信息 弄到 学生表
     */
    @RequestMapping("/addstubbb")
    @ResponseBody
    public ResultDo<Object> addstu(String enterIdcard, double enterPayMoney, String enterPayWay1, HttpSession session)
            throws Exception {
        session.setAttribute("teacherId", "张三");
        String username = (String) session.getAttribute("teacherId");
        System.out.println(enterPayWay1);
        int result = ienter.quertstu(username, enterIdcard, enterPayMoney, enterPayWay1);

        ResultDo<Object> rs = new ResultDo<Object>();
        if (result > 0) {
            rs.setResCode(0);
            rs.setResMsg("请求成功");
            rs.setResData(result);
        } else {
            rs.setResCode(0);
            rs.setResMsg("请求失败");
        }
        return rs;
    }

    /**
     * @param map
     *            storeId 传入题库类型编号 1高升专 2专升本,
     * @return ResultDo<Map<String,List>> 返回试卷详细
     * @throws Exception
     *             int score_type,int course_id int course_id
     *             获得试卷  未启用
     */
/*    @RequestMapping("/getTopics")
    @ResponseBody
    public ResultDo<Object> getPaperDetail() throws Exception {
        int enter_test_type = 1; // 高》本
        System.out.println(enter_test_type);

        ResultDo<Object> res = new ResultDo<Object>();
        // 考试类型 高》本
        res = ienter.getTopicList(enter_test_type);

        return res;
    }*/
    /**
     * @param map
     *            成绩 学生id 申忠正
     * @return ResultDo<String> 提交分数结果
     * @throws Exception
     */
    @RequestMapping("/enterScore")
    @ResponseBody
    public ResultDo<Object> saveScore(@RequestParam Map map) throws Exception {
        System.out.println("saveScore");

        int studentId = 1;
        map.put("studentId", studentId);
        int result = ienter.saveScore(map);

        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        return res;
    }

    @RequestMapping("/cx")
    @ResponseBody
    public int dim(HttpServletRequest req) {
        String a = req.getParameter("serach");
        long a1 = Long.parseLong(a);
        System.out.println(a1);
        int cxxy = ienter.cxidcard(a1);
        System.out.println(cxxy);
        return cxxy;
    }
}
