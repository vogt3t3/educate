package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 视频表
 * @author 刘帅
 *
 */
public class VideoModel implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 视频编号
     */
    private int videoId;
    
    /**
     * 小节编号
     */
    private int partId;
    
    /**
     * 视频名称
     */
    private String videoName;
    
    /**
     * 视频路径
     */
    private String videoPath;
    
    /**
     * 作者
     */
    private String videoAddUser;
    
    /**
     * 发布时间
     */
    private Date addTime;
    
    /**
     * 发布时间字符串
     */
    private String addTimeStr;


    /**
     * 删除状态
     */
    private int videoDelete;
    
    public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoAddUser() {
        return videoAddUser;
    }

    public void setVideoAddUser(String videoAddUser) {
        this.videoAddUser = videoAddUser;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string 
     * @param addTime 数据库取回复日期数据
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
        this.addTimeStr = DateUtil.formatDate(addTime, "yyyy-MM-dd hh:mm:ss");
    }

    
    public String getAddTimeStr() {
        return addTimeStr;
    }
    
    public int getVideoDelete() {
        return videoDelete;
    }

    public void setVideoDelete(int videoDelete) {
        this.videoDelete = videoDelete;
    }
    
    
}
