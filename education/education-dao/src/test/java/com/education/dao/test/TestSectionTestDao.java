package com.education.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.education.dao.SectionTestDao;
/**
 * 章节测试的测试接口
 * @author 赵京华
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class TestSectionTestDao {
	@SuppressWarnings("unused")
	@Autowired
    private SectionTestDao sectionTest;
	@Test
	public void testlistSectionNoVideo() throws Exception{
    	System.out.println(sectionTest.getCourseByStuId(1).size());
    }
	@Test
	public void testgetScore() throws Exception{
		Integer a=sectionTest.getScore(1, 1);
		if(a==null){
			System.out.println("什么都没有");
		}
    	
    }
}
