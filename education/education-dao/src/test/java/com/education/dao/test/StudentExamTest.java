package com.education.dao.test;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.dao.StudentExamDao;
import com.education.model.CourseModel;
/**
 * 学生端 期末考试测试
 * 
 * @author 申忠正
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml" })
public class StudentExamTest {
    @Autowired
    private StudentExamDao sd;
    
    @Test
    public void testaaa() {
        System.out.println("login ! ");
       // 该生课程集合
        List<CourseModel> CourseList;
        try {
            CourseList = sd.queryCourses(1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    

}
