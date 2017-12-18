package com.education.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.StudentExamDao;
import com.education.model.CourseModel;
import com.education.model.ExamCourseModel;
import com.education.model.JudgeTopic;
import com.education.model.ResultDo;
import com.education.model.SelectModel;
import com.education.service.IStudentExam;
/**
 * 学生端期末考试模块的服务层接口实现
 * @author 申忠正
 */
@Service
public class StudentExamImpl implements IStudentExam {
    
    @Autowired
    private StudentExamDao studentExamDao;
    /**
     * 根据学生id查询该生所有课程  及考试信息
     */
    public List<ExamCourseModel> queryCourses(int studentId)  throws Exception {      
        //该生课程集合
        List<CourseModel> CourseList= studentExamDao.queryCourses(studentId);
        //考试信息集合
        List<ExamCourseModel> ExamList = new ArrayList<ExamCourseModel>();
        for(CourseModel course:CourseList){   
            
            System.out.println("课程id = " + course.getCourseId());
            
            //类型暂定！
            ExamList.add(studentExamDao.queryExams(course.getCourseId()));         
        }
        System.out.println("考试记录数  =  " +ExamList.size());
        for(ExamCourseModel e:ExamList){
            System.out.println(e.getExamForm());
        }
        
      return ExamList;
    }
    /**
     * @return 查询返回学生的考试状态 0未预约    1已预约
     */
    @Override
    public ResultDo<Object> getexamstate(int studentId,int examId)  throws Exception {
        ResultDo<Object> res = new ResultDo<Object>();
        int result =  studentExamDao.insertState(studentId,examId);
        if(result==1){
            res.setResData(1);
            return res;
        }else{
            res.setResData(0);
            return res;
        }
/*        ResultDo<Object> res = new ResultDo<Object>();
        //1.查询状态 
        ExamCourseModel examCourseModel = studentExamDao.queryState(studentId,examId);
        System.out.println("ser1" + examCourseModel);
        System.out.println("ser2" + examCourseModel.getOrder_state());
        if(examCourseModel.getOrder_state()==1){
            //直接是成功的           
            res.setResData(2);
            return res;
        }else{
            //预约成功
            int result =  studentExamDao.insertState(studentId,examId);
            System.out.println("ser" +result);
            if(result==1){
                res.setResData(1);
                return res;
            }else{
                res.setResData(0);
                return res;
            }
        }   */     
    }
 
    
    
    
    
    /**试题服务  ----------------------------------------------------------------------------------
     * @author 赵润
     * @param <T>
     *
     */
    /*public ResultDo<Object> getTopicList(int score_type,int course_id) {
        //题库中判断题数量
        int judgeNum=studentExamDao.countJudge(score_type,course_id);
        //题库中选择题数量
        int selectNum=studentExamDao.countSelect(score_type,course_id);
        System.out.println("数量 = " +  judgeNum + " * "+ selectNum);
        
        Set<Integer> judgeSet=new HashSet<Integer>();
        Set<Integer> selectSet=new HashSet<Integer>();
        //判断题的数量
        int judgeSize=10;
        //选择题的数量
        int selectSize=10;
        
        Random ran=new Random();
        //随机出判断题
        while(true){
            int num=ran.nextInt(judgeNum+1);
            if(num!=0){
                judgeSet.add(num); 
            }
            if(judgeSet.size()==10){
                break;
            }
        }
        //随机出选择题
        while(true){
            int num=ran.nextInt(selectNum+1);
            if(num!=0){
                selectSet.add(num);
            }
            if(selectSet.size()==10){
                break;
            }
        }
        //返回判断题集合  ----------------------------------------------------编号   类型  课程号
        List<JudgeTopic> judgeTopicList=studentExamDao.listJudge(judgeSet, score_type,course_id);
        //选择题集合
        List<SelectModel> selectTopicList=studentExamDao.listSelect(selectSet, score_type,course_id);
        
        System.out.println(selectTopicList.toString());
        System.out.println("选择题数量 =  "+selectTopicList.size());
        System.out.println("判断题数量 =  "+judgeTopicList.size());
        
        Map<String,List> map=new HashMap<String,List>();
        map.put("judgeTopics", judgeTopicList);
        map.put("selectTopics", selectTopicList);
        //返回数据
        ResultDo<Object> res=new ResultDo<Object>();
        res.setResCode(0);
        res.setResMsg("success");
        res.setResData(map);
        return res;
    }*/
    
    /**试题服务  ----------------------------------------------------------------------------------
     * @author 赵润
     * @param <T>
     *
     */
    public ResultDo<Object> getTopicList(int score_type,int course_id) {
       // System.out.println("ser1");
        //题库中判断题      试题 集合 
        List<JudgeTopic> judgeList=studentExamDao.countJudge(score_type,course_id);
        //题库中选择题   试题集合 
        List<SelectModel> seleList=studentExamDao.countSelect(score_type,course_id);
        //长度
      //  System.out.println("数量 = " +  judgeList.size() + " * "+ seleList.size());
        
      //  System.out.println("ser2");
        
        Set<JudgeTopic> judgeSet=new HashSet<JudgeTopic>();
        Set<SelectModel> selectSet=new HashSet<SelectModel>();      
        Random ran=new Random();
        //随机出判断题
        while(true){
            
            int num=ran.nextInt(judgeList.size());
       
            //System.out.println("random = " + num);
           
                judgeSet.add(judgeList.get(num)); 
            
            if(judgeSet.size()==5){
                break;
            }
        }
        
        //随机出选择题
        while(true){
            int num=ran.nextInt(seleList.size());
           
            selectSet.add(seleList.get(num));           
            if(selectSet.size()==5){
                break;
            }
        }
        
       // System.out.println("ser3");            
        //System.out.println("选择题数量 =  "+selectSet.size());
       // System.out.println("判断题数量 =  "+judgeSet.size());        
        List selectList2 = new ArrayList(selectSet);
        List judgeList2 = new ArrayList(judgeSet);
        
        Map<String,List> map=new HashMap<String,List>();
        map.put("judgeTopics",judgeList2);
        map.put("selectTopics",selectList2);
            
        ResultDo<Object> res=new ResultDo<Object>();
        res.setResCode(0);
        res.setResMsg("success");
        res.setResData(map);
        return res;
    }
    /**
     * @param map 成绩  课程id 学生id
     * @return
     * @throws Exception
     */
    @Override
    public int saveScore(Map map) throws Exception {
        int result = studentExamDao.saveScore(map);
        
          int scoreExam = Integer.parseInt(map.get("total").toString());
           int courseId = Integer.parseInt(map.get("course_id").toString());
           int studentId = Integer.parseInt(map.get("studentId").toString());       
           System.out.println("服务 " +" * "+ scoreExam+" * "+ courseId+" * "+studentId);        
        return 0;
    }
}
