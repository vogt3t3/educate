package com.education.dao;

import com.education.model.VideoModel;

/**
 * 获得视频
 * @author 刘帅
 *
 */
public interface PlayVideoDao {

    /**
     * 得到视频
     * @param partId 小节编号
     * @return 视频
     */
    VideoModel getVideo(int partId);
}
