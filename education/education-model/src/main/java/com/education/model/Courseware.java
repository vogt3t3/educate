package com.education.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.education.util.DateUtil;

/**
 * 导学课件类
 * 
 * @author shenZhongzheng
 *
 */

@Component
public class Courseware implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 课件编号  
     */
    private int coursewareId;
    /**
     * 课件名称
     */
    private String coursewareName;
    /**
     * 课件大小
     */
    private int coursewareSize;
    /**
     * 课件路径
     */
    private String coursewarePath;
    /**
     * 发布时间
     */
    private Date coursewareAddtime;
    /**
     * 发布时间2 --格式 yyyy-MM-dd
     */
    private String coursewareAddtimeStr;
    /**
     * 删除状态
     */
    private int coursewareDelete;

    public int getCoursewareId() {
        return coursewareId;
    }

    public void setCoursewareId(int coursewareId) {
        this.coursewareId = coursewareId;
    }

    public String getCoursewareName() {
        return coursewareName;
    }

    public void setCoursewareName(String coursewareName) {
        this.coursewareName = coursewareName;
    }

    public int getCoursewareSize() {
        return coursewareSize;
    }

    public void setCoursewareSize(int coursewareSize) {
        this.coursewareSize = coursewareSize;
    }

    public String getCoursewarePath() {
        return coursewarePath;
    }

    public void setCoursewarePath(String coursewarePath) {
        this.coursewarePath = coursewarePath;
    }

    public Date getCoursewareAddtime() {
        return coursewareAddtime;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string 
     * @param coursewareAddtime 数据库取回复日期数据
     */
    public void setCoursewareAddtime(Date coursewareAddtime) {
        this.coursewareAddtime = coursewareAddtime;
        this.coursewareAddtimeStr = DateUtil.formatDate(coursewareAddtime, "yyyy-MM-dd");
    }

    public String getCoursewareAddtimeStr() {
        return coursewareAddtimeStr;
    }

    public int getCoursewareDelete() {
        return coursewareDelete;
    }

    public void setCoursewareDelete(int coursewareDelete) {
        this.coursewareDelete = coursewareDelete;
    }

}