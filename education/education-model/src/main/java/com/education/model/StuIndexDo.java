package com.education.model;

import java.io.Serializable;

/**
 * 学习主页的实体类
 * @author 刘帅
 *
 */
public class StuIndexDo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 课程编号
     */
    private int courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 教师名称
     */
    private String teacherName;
    /**
     * 学分
     */
    private int scoreCredit;
    
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
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public int getScoreCredit() {
        return scoreCredit;
    }
    public void setScoreCredit(int scoreCredit) {
        this.scoreCredit = scoreCredit;
    }

}
