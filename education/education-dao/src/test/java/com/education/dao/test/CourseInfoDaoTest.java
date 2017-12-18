package com.education.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.CourseInfoDao;
import com.education.model.CourseDo;

/**
 * 课程详细信息测试类
 *  @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class CourseInfoDaoTest {

    @Autowired
    private CourseInfoDao courseInfo;
    
    @Test
    public void test() {
        
        CourseDo course = courseInfo.getCourseInfo(1);
        System.out.println(course.getVideoName());
    }

}
