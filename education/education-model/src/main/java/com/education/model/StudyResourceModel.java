package com.education.model;

import java.io.Serializable;

/**
 * 导学资源
 * @author 赵睿慷
 *
 */
public class StudyResourceModel extends TeacherModel implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 资料编号
     */
    private int resourceId;
    /**
     * 资料名称
     */
    private String resourceName;
    /**
     * 资料标题
     */
    private String resourceTitle;
    /**
     * 资料描述
     */
    private String resourceDescribe;
    /**
     * 访问次数
     */
    private int resourceFrequence;
    /**
     * 删除状态
     */
    private int resourceDelete;
    /**
     * 课程编号
     */
    private int courseId;  
    
    /**
     * 课程名称
     */
    private String courseName;  
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getResourceId() {
        return resourceId;
    }
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public String getResourceTitle() {
        return resourceTitle;
    }
    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }
    public String getResourceDescribe() {
        return resourceDescribe;
    }
    public void setResourceDescribe(String resourceDescribe) {
        this.resourceDescribe = resourceDescribe;
    }
    public int getResourceFrequence() {
        return resourceFrequence;
    }
    public void setResourceFrequence(int resourceFrequence) {
        this.resourceFrequence = resourceFrequence;
    }
    public int getResourceDelete() {
        return resourceDelete;
    }
    public void setResourceDelete(int resourceDelete) {
        this.resourceDelete = resourceDelete;
    }
    @Override
    public String toString() {
        return "StudyResourceModel [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceTitle="
                + resourceTitle + ", resourceDescribe=" + resourceDescribe + ", resourceFrequence=" + resourceFrequence
                + ", resourceDelete=" + resourceDelete + ", courseId=" + courseId + ", courseName=" + courseName + "]";
    }
  
}
