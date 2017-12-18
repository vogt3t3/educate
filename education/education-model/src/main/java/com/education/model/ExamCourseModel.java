package com.education.model;

import java.io.Serializable;

/**
 * @author 申忠正
 *考试信息扩展类  用于学生端
 */
public class ExamCourseModel extends ExamInf implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 课程
     */
    private int courseId;
    
    /**
     * 科目
     */
    private String examname;

    /**
     * 学生id
     */
    private int studentId;
    /**
     * 学生预约状态
     */
    private int order_state;
    
    
    
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public int getOrder_state() {
        return order_state;
    }
    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }
    public String getExamname() {
        return examname;
    }
    public void setExamname(String examname) {
        this.examname = examname;
    }
    
}   
