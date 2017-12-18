package com.education.service.test;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.ScoreDao;
import com.education.dao.TeacherEvaluationDao;
import com.education.dao.TeacherInfoDao;
import com.education.model.StudentScoreModel;
import com.education.model.TeaEvaluationModel;
import com.education.model.TeacherModel;



@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/spring.xml"})
public class Test {
    @Autowired
    private TeacherInfoDao teacherInfoDao;
    @Autowired
    private ScoreDao scoreDao;
    
    @org.junit.Test
    public void test1() throws Exception{
        System.out.println(teacherInfoDao);
        System.out.println(teacherInfoDao.getTeacherList(1));
        List<TeacherModel> teaList=teacherInfoDao.getTeacherList(1);
        for (TeacherModel teacherModel : teaList) {
            System.out.println(teacherModel.getCourseModel().getCourseName());
        }
    }
    @org.junit.Test
    public void test2() throws Exception{
        
        List<StudentScoreModel> stuList=scoreDao.stuScoreList(null, "z");
        for (StudentScoreModel studentScoreModel : stuList) {
            System.out.println(studentScoreModel.getCourseName());
        }
    }
    @org.junit.Test
    public void test3() throws Exception{
        StudentScoreModel studentScoreModel=new StudentScoreModel();
        studentScoreModel.setModifyDate(new Date());
        System.out.println(studentScoreModel.getStrModifyDate());
        studentScoreModel.setModifyPerson("fengyunwei");
        studentScoreModel.setScoreId(1);
        studentScoreModel.setScoreExam(20);
        studentScoreModel.setScoreOntime(20);
        studentScoreModel.setScorePlay(20);
        studentScoreModel.setScoreTest(20);
        scoreDao.updateScore(studentScoreModel);
        
      
    }
    @org.junit.Test
    public void test4() throws Exception{
        StudentScoreModel studentScoreModel=new StudentScoreModel();
        int courseId=scoreDao.getcourseId("计算机1");
        int studentId=scoreDao.getstuId("啊大");
        studentScoreModel.setCourseId(courseId);
        studentScoreModel.setStudentId(studentId);
        studentScoreModel.setScoreExam(20);
        studentScoreModel.setScoreOntime(20);
        studentScoreModel.setScorePlay(20);
        studentScoreModel.setScoreTest(20);
        studentScoreModel.setModifyDate(new Date());
        studentScoreModel.setModifyPerson("fenyunwei");
        studentScoreModel.setScoreCreateDate(new Date());
        studentScoreModel.setScoreCredit(100);
        studentScoreModel.setScoreDelete(1);
        scoreDao.addScore(studentScoreModel);
    }
}
     
