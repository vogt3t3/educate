package com.education.student.controller;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ExamCourseModel;
import com.education.model.ResultDo;
import com.education.model.SelectModel2;
import com.education.service.IStudentExam;
/**
 * 该模块是学生端期末考试模块 -显示信息 以及 预约 - 点击开始考试即可开始考试
 * @author 申忠正
 *                
 */
@Controller
@RequestMapping("/api/student")
public class StudentExamController {
    /**
     * 日志记录类
     */
    private static Logger myLogger = LogManager.getLogger(StudentExamController.class.getName());
    /**
     * 注入业务控制层
     */
    @Reference
    private IStudentExam istudentExam;
    /**
     * 根据学生id查询该生所有课程  及考试信息
     * @return ExamList
     */
    @RequestMapping("/StudentExamController/getexamMsg")
    @ResponseBody
    public ResultDo<Object> getexamMsg2() throws Exception {     
        List<ExamCourseModel> ExamList = istudentExam.queryCourses(2);     
        ResultDo<Object> res = new ResultDo<Object>();  
        res.setResData(ExamList);
        return res;       
    }
    /**
     * 点击更改考试预约状态
     * 返回值code 代表 0（失败，未预约上）， 1（预约成功）， 2（已经预约）
     * */
    @RequestMapping("/StudentExamController/getexamstate")
    @ResponseBody
    public ResultDo<Object> getexamstate(int examId) throws Exception {
        //学生id从session中取
        int  studentId = 2;  
        ResultDo<Object> res = istudentExam.getexamstate(studentId, examId);  
        return res;       
    }
    /**试题
     * @author 赵润
     * @param <T> ----------------------------------------------------------------------------------
     *
     */
    /**
     * @param map storeId 传入题库类型编号,
     * param map storeId 传入课程id,
     * @return ResultDo<Map<String,List>> 返回试卷详细    
     * @throws Exception    int score_type,int course_id  int course_id
     */
   // @SuppressWarnings("unchecked")
    @RequestMapping("/StudentExamController/topics")
    @ResponseBody
    public ResultDo<Object> getPaperDetail() throws Exception {
        int score_type = 1;
       System.out.println( " 课程id = "+1+ " 类型 " + score_type);
        ResultDo<Object> res = new ResultDo<Object>();
       // res = istudentExam.getTopicList((Integer) map.get("scoreType"));
        //考试类型  课程id
        res = istudentExam.getTopicList(score_type,1);
        myLogger.info("出试卷成功");
        return res;
    }
    /**
     * @param map 成绩  课程id 学生id  申忠正
     * @return ResultDo<String> 提交分数结果
     * @throws Exception
     */
    @RequestMapping("/StudentExamController/commitScore")
    @ResponseBody
    public ResultDo<Object> saveScore(@RequestBody Map map) throws Exception{
        System.out.println("saveScore");
        //结业成绩  --->> 期末成绩  
       //自定义 学生id
       int studentId = 1; 
       map.put("studentId", studentId);
       int result = istudentExam.saveScore(map);
       System.out.println("结果 = " + result);
       
       ResultDo<Object> res = new ResultDo<Object>();
       res.setResCode(0);
       return res;
    }
}
