package com.education.dao.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.MangerEnrollDao;
import com.education.model.EnrollStudents;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class MangerEnrollTest {
    @Autowired
    private  MangerEnrollDao mangerEnrollDao;
    /**
     * @throws Exception
     */
    @Test
    public void test() throws Exception{

        EnrollStudents en=new EnrollStudents();
        en.setEnrollArea("1");
        en.setEnrollEduSystem("1");
        en.setEnrollModel("1");
        en.setEnrollStudentId(1);
       en.setEnrollStudentNum(2);
       en.setMajorId(1);
     
        en.setEnrollCreateDate(new Date());
        en.setEnrollModifyDate(new Date());
        en.setEnrollModifyPerson("李志鹏");
        mangerEnrollDao.addEnroll(en);
    }

}
