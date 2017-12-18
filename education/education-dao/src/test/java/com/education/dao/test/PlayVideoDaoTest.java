package com.education.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.dao.PlayVideoDao;
import com.education.model.VideoModel;

/**
 * 获取视频测试类
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class PlayVideoDaoTest {

    @Autowired
    private PlayVideoDao playVideo;
    
    @Test
    public void test() {
        
        VideoModel video= playVideo.getVideo(1);
        System.out.println(video);
    }

}
