package com.education.model;

/**
 * 课程的扩展类
 * @author 刘帅
 *
 */
public class CourseDo extends CourseModel {
    
    /**
     * 小节编号
     */
    private int partId;
    
    /**
     * 小节名称
     */
    private String partName;
    
    /**
     * 访问次数
     */
    private int partFrequence;
    
    /**
     * 视频编号
     */
    private int videoId;
    
    /**
     * 视频名称
     */
    private String videoName;

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getPartFrequence() {
        return partFrequence;
    }

    public void setPartFrequence(int partFrequence) {
        this.partFrequence = partFrequence;
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
    
    
}
