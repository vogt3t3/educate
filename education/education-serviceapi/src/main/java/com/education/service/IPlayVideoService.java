package com.education.service;

import com.education.model.ResultDo;
import com.education.model.VideoModel;

/**
 * 视频播放服务层
 * @author 刘帅
 *
 */
public interface IPlayVideoService {
    
    /**
     * 得到视频
     * @param partId 小节编号
     * @return 视频
     */
    ResultDo<VideoModel> getVideo(int partId);
}
