package com.education.dao.test;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.SectionPartDao;
import com.education.model.SecondSection;

/**
 * 单元测试查询章节信息接口
 * @author 杨振欣
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class TestSectionPartDao {
    /**
     * 
     */
    @Autowired
    private SectionPartDao sectiondao;
    /**
     * @throws Exception 抛出业务层异常
     */
    @Test
    public void testlistSectionNoVideo() throws Exception{
    	System.out.println(sectiondao.listSectionNoVideo(1).get(0).getChildren().size());
    }
    @Test
    public void test() throws Exception {
        System.out.println(sectiondao.listAllSection(1).get(0).getChildren().get(0).getVideoId());
    }
    @Test
    public void classnametest() throws Exception {
        System.out.println(sectiondao.queryClassName(1));
    }
    
    @Test
    public void testlistSectionNoSecond() throws Exception {
        System.out.println(sectiondao.listSectionNoSecond(1).size());
    }
    @Test
    public void testaddSmallSection() throws Exception {
    	Date addDate=new Date();
    	SecondSection secondSection=new SecondSection();
		secondSection.setSection_id(1);
		secondSection.setPart_frequence(0);
		secondSection.setPart_addtime(addDate);
		secondSection.setPart_id_name("不必填写");
		secondSection.setPart_modify_date(addDate);
		secondSection.setPart_modify_person("zhangsan");
		secondSection.setPart_name("asdfasdfasdfasdfasdfasdfasd");
		System.out.println(sectiondao.addSmallSection(secondSection));
    }
}
