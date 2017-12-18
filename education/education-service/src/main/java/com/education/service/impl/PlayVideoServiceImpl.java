package com.education.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.PlayVideoDao;
import com.education.model.CourseDo;
import com.education.model.ResultDo;
import com.education.model.VideoModel;
import com.education.service.IPlayVideoService;
import com.education.util.PropertiesUtil;

/**
 * 播放视频服务层
 * @author 刘帅
 *
 */
@Service
public class PlayVideoServiceImpl implements IPlayVideoService{
    
    /**
     * 播放视频数据层
     */
    @Autowired
    private PlayVideoDao playVideo;
    
    /**
     * 日志记录类
     */
    private static Logger MYLOGGER = LogManager.getLogger(StuIndexServiceImpl.class);
    
    /**
     * 得到视频
     * @param partId 小节编号
     * @return 视频
     */
    public ResultDo<VideoModel> getVideo(int partId) {
        
        VideoModel video = playVideo.getVideo(partId);
        String path = video.getVideoPath();
        video.setVideoPath(PropertiesUtil.download+path);
        ResultDo<VideoModel> resultDo = new ResultDo<VideoModel>();
        resultDo.setResData(video);
        MYLOGGER.info(video.getVideoName());
        return resultDo;
    }

}
