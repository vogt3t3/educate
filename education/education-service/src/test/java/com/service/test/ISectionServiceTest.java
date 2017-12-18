package com.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.SectionPartDao;

/**
 * 章节管理实体查询
 * @author 杨振欣
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class ISectionServiceTest {
    /**
     * 注入业务层接口
     */
    @Autowired
    private SectionPartDao sectionPartDao;
    /**
     * @throws Exception 
     * 
     */
    @Test
    public void test() throws Exception{
    	System.out.println(sectionPartDao.listAllSection(1).size());
    }
    @Test
    public void classnametest() throws Exception{
    	System.out.println(sectionPartDao.queryClassName(1));
    }
}
