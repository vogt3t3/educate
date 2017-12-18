package com.education.model;

/**
 * 论文管理的扩展类
 * @author 刘帅
 *
 */
public class ThesisDo extends ThesisModel {
    
    /**
     * 学生姓名
     */
    private String studentName;
    
    /**
     * 学生编号
     */
    private int studentId;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
}
