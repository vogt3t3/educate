package com.education.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.PartSectionDao;
import com.education.model.PartSectionModel;

/**
 * 获取小节的测试
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class PartSectionDaoTest {
    
    @Autowired
    private PartSectionDao partSection;
    
    @Test
    public void test() {
        
        List<PartSectionModel> partList = partSection.queryPart(1);
        System.out.println(partList);
    }

}
