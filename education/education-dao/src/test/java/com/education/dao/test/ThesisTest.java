package com.education.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.ManageThesisDao;
import com.education.model.ThesisDo;

/**
 * 论文管理测试
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class ThesisTest {

    @Autowired
    private ManageThesisDao manage;
    
    @Test
    public void test() {
        
        List<ThesisDo> thesisList = manage.getThesis();
        System.out.println(thesisList);
    }

}
