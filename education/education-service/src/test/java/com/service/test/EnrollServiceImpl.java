package com.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.MangerEnrollDao;
import com.education.model.EnrollStudents;
import com.education.model.EnrollStudentsModel;


/**
 * 招生计划测试
 * @author 李志鹏
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class EnrollServiceImpl {
    /**
     * 注入业务层接口
     */
    @Autowired
    private MangerEnrollDao med;
    /**
     * @throws Exception 
     * 
     */
    @Test
    public void test() throws Exception{
        List<EnrollStudents> list= med.queryEnrollStudent(1);
        for(EnrollStudents esm:list){
           System.out.println(esm.getEnrollArea()+esm.getEnrollModel());
      }
    }
}
