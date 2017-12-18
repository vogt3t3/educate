package com.education.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.education.model.ResultDo;
import com.education.model.VideoModel;
import com.education.service.impl.PlayVideoServiceImpl;

/**
 * 播放视频测试类
 * @author 刘帅
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring.xml" })
public class PlayVideoServiceTest {
    
    @Autowired
    private PlayVideoServiceImpl playVideo;

    @Test
    public void test() {
        ResultDo<VideoModel> resultDo = playVideo.getVideo(1);
        
        System.out.println(resultDo.getResData().getVideoName());
    }

}
