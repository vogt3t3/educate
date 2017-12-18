package com.education.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.StuCourseDao;
import com.education.model.SectionDo;
import com.education.model.SectionModel;

/**
 * 学习课程测试类
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class StuCourseDaoTest {

    @Autowired
    private StuCourseDao stuCourse;
    
    @Test
    public void test() {
        
        List<SectionDo> sectionList = stuCourse.querySection(1);
        System.out.println(sectionList);
    }

}
