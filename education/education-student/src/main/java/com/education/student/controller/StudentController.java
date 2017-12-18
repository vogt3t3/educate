package com.education.student.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ClassEvaluate;
import com.education.model.CourseDo;
import com.education.model.CourseModel;
import com.education.model.PartSectionModel;
import com.education.model.ResultDo;
import com.education.model.SectionDo;
import com.education.model.StuIndexDo;
import com.education.model.StudentModel;
import com.education.model.StudentScoreModel;
import com.education.model.User;
import com.education.model.VideoModel;
import com.education.service.ICourseInfoService;
import com.education.service.IEvaluateService;
import com.education.service.IPartSectionService;
import com.education.service.IPlayVideoService;
import com.education.service.IStuCourseService;
import com.education.service.IStuIndexService;
import com.education.service.IStudentScoreService;
import com.education.service.IUserService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 学生控制层实例
 * 
 * @author Administrator
 *
 */

@RestController
public class StudentController {
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StudentController.class.getName());
    /**
     * 注入用户业务处理接口
     */
    @Reference
    private IUserService iuserService;
    /**
     * 学生成绩服务实现
     */
    @Reference
    private IStudentScoreService studentScoreService;
    
    /**
     * 学生主页实现
     */
    @Reference
    private IStuIndexService stuIndexService;
    
    /**
     * 课程评价服务层
     */
    @Reference
    private IEvaluateService evaluateService;
    
    /**
     * 学习课程服务层
     */
    @Reference
    private IStuCourseService stuCourseService;
    
    /**
     * 小节服务层
     */
    @Reference
    private IPartSectionService partSectionService;
    
    /**
     * 课程详细信息
     */
    @Reference
    private ICourseInfoService courseInfo;
    
    /**
     * 播放视频
     */
    @Reference
    private IPlayVideoService playVideo;

    /**
     * 查询数据以及日志的记录实例
     * 
     * @return String
     * @throws Exception  抛异常
     */
    @SuppressWarnings("deprecation")
    @RequestMapping("/stu")
    public String listUserByName() throws Exception {
        System.out.println("44545");
        System.out.println(iuserService);
        MYLOGGER.entry(); // trace级别的信息，单独列出来是希望你在某个方法或者程序逻辑开始的时候调用，和logger.trace("entry")基本一个意思
        MYLOGGER.error("Did it again!"); // error级别的信息，参数就是你输出的信息
        MYLOGGER.info("我是info信息"); // info级别的信息
        MYLOGGER.debug("我是debug信息");
        MYLOGGER.warn("我是warn信息");
        MYLOGGER.fatal("我是fatal信息");
        MYLOGGER.log(Level.DEBUG, "我是debug信息"); // 这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        MYLOGGER.exit(); // 和entry()对应的结束方法，和logger.trace("exit");一个意思
        PageInfo<User> pro = iuserService.queryByPage("lisi", 1, 5);
        List<User> users = pro.getList();
        for (User user : users) {
           // MYLOGGER.info(user.getUsername());
        }
        return "";
    }

   
    /**
     * @param map 登录信息
     * @return ResultDo<StudentModel>
     * @throws Exception 抛异常
     */
    @RequestMapping("/api/user/login")
    @ResponseBody
    public ResultDo<StudentModel> stuLogin(@RequestBody Map<String,String> map) throws Exception{
        MYLOGGER.info("登录验证");
        ResultDo<StudentModel> result = new ResultDo<StudentModel>();
        result.setResCode(0);
        result.setResMsg("");
        StudentModel stu = new StudentModel();
        stu.setStudentId(1);
        result.setResData(stu);
        return result;
    }

    /**
     * 查询学生stuId的课程成绩组成
     * @param map 学生编号stuId courseId
     * @return ResultDo<List<StudentScoreModel>>
     * @throws Exception 抛异常
     */
    @RequestMapping("/api/stu/scoreDetail")
  
    public ResultDo<StudentScoreModel> getStuScoreGroup(@RequestBody Map<String,Integer> map)
            throws Exception {
        MYLOGGER.info("查询学生-----" + map.get("stuId") + "------的课程----" + map.get("courseId") + "-----组成成绩");
        ResultDo<StudentScoreModel> resultDo = new ResultDo<StudentScoreModel>();
        resultDo = studentScoreService.getListStudentSectionScore((Integer)map.get("stuId"), (Integer)map.get("courseId"));
        MYLOGGER.info(resultDo.toString());
        return resultDo;
    }
    
    /** 学生课程分数列表
     * @param map 学生编号studentId
     * @return ResultDo<List<StudentScoreModel>>
     * @throws Exception 抛异常
     */
    @RequestMapping("/api/stu/score")
    @ResponseBody
    public ResultDo<List<StudentScoreModel>> getStudentScore(HttpSession session) throws Exception {
        MYLOGGER.info("查询学生-----" + session.getAttribute("stuId"));
        ResultDo<List<StudentScoreModel>> resultDo = new ResultDo<List<StudentScoreModel>>();
        resultDo = studentScoreService.getListStudentScore(Integer.parseInt(session.getAttribute("stuId").toString()));
        MYLOGGER.info(resultDo.toString());
        return resultDo;
    }
    /** 成绩异议
     * @param map 学生编号stuId 审查说明 inf 课程编号courseId
     * @return 提交审查结果
     * @throws Exception 抛异常
     */
    @RequestMapping("/api/stu/addcheck")
    @ResponseBody
    public ResultDo<String> docheck(@RequestBody Map<String,Object> map) throws Exception{
        ResultDo<String> resultDo = new ResultDo<String>();
        MYLOGGER.info("提交学生-----" + map.get("stuId") + "------的课程-----"+map.get("courseId")+"-----成绩异议");
        resultDo=studentScoreService.doAddDissent((Integer)map.get("stuId"), (Integer)map.get("courseId"), map.get("inf").toString(), new Date());
        return resultDo;
    }

    
}
