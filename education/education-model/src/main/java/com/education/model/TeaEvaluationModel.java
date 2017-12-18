package com.education.model;

import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 教师评价实体类
 * @author FYM
 *
 */
public class TeaEvaluationModel implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
	 * 教师评价的id
	 */
    private int teacherEvaluateId;
    /**
     * 学生编号
     */
    private int studentId;
    /**
     * 教师编号
     */
    private int teacherId;
    /**
     * 老师评价的内容
     */
    private String teaEvaContent;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 老师名称
     */
    private String teacherRealName;
    /**
     * 老师评价的时间
     */
    private Date teaEvaDate;
    /**
     * 评价时间的字符串
     */
    private String teaEvaDateStr;
    /**
     * 老师评价的删除状态
     * （0表示已经删除，1表示未删除）
     */
    private int teaEvaDel;
    public int getTeacherEvaluateId() {
    	return teacherEvaluateId;
    }
    public void setTeacherEvaluateId(int teacherEvaluateId) {
    	this.teacherEvaluateId = teacherEvaluateId;
    }
    public String getTeaEvaContent() {
    	return teaEvaContent;
    }
    public void setTeaEvaContent(String teaEvaContent) {
    	this.teaEvaContent = teaEvaContent;
    }
    public Date getTeaEvaDate() {
    	return teaEvaDate;
    }
    /**
     * 数据库传输数据为Date类型
     * 前台取时用字符串
     * @param teaEvaDate 数据库取的日期数据
     */
    public void setTeaEvaDate(Date teaEvaDate) {
    	this.teaEvaDateStr=DateUtil.formatDate(teaEvaDate, "yyyy-MM-dd HH:mm:ss");
    	this.teaEvaDate = teaEvaDate;
    }
    public String getTeaEvaDateStr() {
    	return teaEvaDateStr;
    }
    public int getTeaEvaDel() {
    	return teaEvaDel;
    }
    public void setTeaEvaDel(int teaEvaDel) {
    	this.teaEvaDel = teaEvaDel;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getTeacherRealName() {
        return teacherRealName;
    }
    public void setTeacherRealName(String teacherRealName) {
        this.teacherRealName = teacherRealName;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    @Override
    public String toString() {
        return "TeaEvaluationModel [teacherEvaluateId=" + teacherEvaluateId + ", teaEvaContent=" + teaEvaContent
                + ", teaEvaDate=" + teaEvaDate + ", teaEvaDateStr=" + teaEvaDateStr + ", teaEvaDel=" + teaEvaDel + "]";
    }
    
}
