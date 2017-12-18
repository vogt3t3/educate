package com.education.model;

import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 课程类
 * @author 刘帅
 *
 */   
public class CourseModel extends MajorModel implements Serializable{
    
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
     * 课程学分
     */
    private int courseScore;    
    
    /**
     * 课程版本
     */
    private String courseEdition;  
   
    /**
     * 课程类别
     */
    private String courseClass;    
    
    /**
     * 在线测试分数
     */
    private int onlineTestScorce;   
    
    /**
     * 课程结业考试分数
     */
    private int finalTestScorce;   
    
    /**
     * 在线时长分数
     */
    private int onlineScorce;      
    
    /**
     * 课程进度
     */
    private double coursePlan;  
    
    /**
     * 创建时间
     */
    private Date createDate;
    
    /**
     * 创建时间的字符串显示
     */
    private String createDateStr;
    
    /**
     * 修改时间
     */
    private Date modifyDate;
    
    /**
     * 修改时间的字符串显示
     */
    private String modifyDateStr;

    /**
     * 删除状态
     */
    private int courseDelete;
    
    /**
     * 教师编号
     */
    private int teacherId;
    
    /**
     * 教师姓名
     */
    private String teacherRealName;

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

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param createDate 数据库取添加日期数据
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
        this.createDateStr = DateUtil.formatDate(createDate, "yyyy-MM-dd hh:mm:ss");
    }
    
    public String getCreateDateStr() {
        return createDateStr;
    }

    
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param modifyDate 数据库取添加日期数据
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        this.modifyDateStr = DateUtil.formatDate(modifyDate, "yyyy-MM-dd hh:mm:ss");
    }
   
    public String getModifyDateStr() {
        return modifyDateStr;
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
    public int getCourseScore() {
        return courseScore;
    }
    public void setCourseScore(int courseScore) {
        this.courseScore = courseScore;
    }
    public String getCourseEdition() {
        return courseEdition;
    }
    public void setCourseEdition(String courseEdition) {
        this.courseEdition = courseEdition;
    }
    public String getCourseClass() {
        return courseClass;
    }
    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }
    
    public int getOnlineTestScorce() {
        return onlineTestScorce;
    }
    public void setOnlineTestScorce(int onlineTestScorce) {
        this.onlineTestScorce = onlineTestScorce;
    }
    public int getFinalTestScorce() {
        return finalTestScorce;
    }
    public void setFinalTestScorce(int finalTestScorce) {
        this.finalTestScorce = finalTestScorce;
    }
    public int getOnlineScorce() {
        return onlineScorce;
    }
    public void setOnlineScorce(int onlineScorce) {
        this.onlineScorce = onlineScorce;
    }
    public double getCoursePlan() {
        return coursePlan;
    }
    public void setCoursePlan(double coursePlan) {
        this.coursePlan = coursePlan;
    }
    public int getCourseDelete() {
        return courseDelete;
    }
    public void setCourseDelete(int courseDelete) {
        this.courseDelete = courseDelete;
    }
    
    public Date getCreateDate() {
        return createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    @Override
    public String toString() {
        return "CourseModel [courseId=" + courseId + ", courseName=" + courseName + ", courseScore=" + courseScore
                + ", courseEdition=" + courseEdition + ", courseClass=" + courseClass + ", onlineTestScorce="
                + onlineTestScorce + ", finalTestScorce=" + finalTestScorce + ", onlineScorce=" + onlineScorce
                + ", coursePlan=" + coursePlan + ", createDate=" + createDate + ", createDateStr=" + createDateStr
                + ", modifyDate=" + modifyDate + ", modifyDateStr=" + modifyDateStr + ", courseDelete=" + courseDelete
                + ", teacherId=" + teacherId + ", teacherRealName=" + teacherRealName + "]";
    }
    
    
}
