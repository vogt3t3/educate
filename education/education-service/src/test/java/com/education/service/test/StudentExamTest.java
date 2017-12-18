package com.education.service.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.service.IStudentExam;
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
    private IStudentExam add;
    @Test
    public void testaaa() {
        System.out.println("login ! ");
        try {
            add.queryCourses(2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    

}
