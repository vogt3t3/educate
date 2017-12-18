package com.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.service.IEnterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class EnterTest {

    @Autowired
    private IEnterService ienterService;

    @Test
    public void test1() throws Exception {
        int result = ienterService.quertstu("张三", "9123456789123456009", 4500.0, "微信");
        System.out.println("1111111111: " + result);
    }

}
