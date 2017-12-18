package com.education.model;

import java.io.Serializable;

/**
 * 导学资源-教师-课程   扩展字段
 * @author 申忠正
 */
public class ResourceTCModel extends StudyResourceModel implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 教师编号
     */
    private int teacherId;
    /**
     * 真实姓名
     */
    private String teacherRealName;
    
    /**
     * 课程编号
     */
    private int courseId;  
    
    /**
     * 课程名称
     */
    private String courseName;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherRealName() {
        return teacherRealName;
    }

    public void setTeacherRealName(String teacherRealName) {
        this.teacherRealName = teacherRealName;
    }

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
    
    
}
