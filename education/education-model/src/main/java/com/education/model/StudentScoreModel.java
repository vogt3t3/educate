package com.education.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.education.util.DateUtil;

/**
 * 学生成绩
 * 
 * @author ZHAORUN
 *
 */

public class StudentScoreModel implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 成绩表编号
     */
    private int scoreId;
    /**
     * 学生id
     */
    private int studentId;
    /**
     * 学生名称
     */
    private String studentName;
    /**
     * 考试总成绩
     */
    private int score;
    /**
     * 课件点播分数
     */
    private int scorePlay;
    /**
     * 在线时间分数
     */
    private int scoreOntime;
    /**
     * 小节测试分数
     */
    private int scoreTest;
    /**
     * 课程结业考试分数
     */
    private int scoreExam;
    /**
     * 学生每门课学分
     */
    private int scoreCredit;
    /**
     * 成绩录入时间
     */
    private Date scoreCreateDate;
    /**
     * 成绩录入时间
     */
    private String strScoreCreateDate;
    
    /**
     * 最近修改人
     */
    private String modifyPerson;
    /**
     * 最近修改时间
     */
    private Date modifyDate;
    /**
     * 最近修改时间
     */
    private String strModifyDate;
    /**
     * 课程编号
     */
    private int courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 状态 0代表未考试 1代表已考 
     */
    private int scoreDelete;
    /**
     * 发布时间 Date
     */
    private Date examAddtime;
    /**
     * 发布时间 String
     */
    private String strExamAddtime;
    /**
     * 考试状态 int
     */
    private int examDelete;
    /**
     * 考试状态 String
     */
    private String strExamDelete;
    /**
     * 章节
     */
    private List<Section> sectionList;
    

    public String getExamAddtime() {
        return strExamAddtime;
    }

    /**
     * @param examAddtime 考试时间
     */
    public void setExamAddtime(Date examAddtime) {
        this.strExamAddtime=DateUtil.formatDate(examAddtime, "yyyy-MM-dd");
        this.examAddtime = examAddtime;
    }

    public String getStrExamAddtime() {
        return strExamAddtime;
    }

    public String getExamDelete() {
        return strExamDelete;
    }

    public void setExamDelete(int examDelete) {
        if(examDelete==1)
            this.strExamDelete="考试通过";
        else
            this.strExamDelete="考试未通过";
        
        this.examDelete = examDelete;
    }
    

    public String getStrExamDelete() {
        return strExamDelete;
    }

    public void setStrExamDelete(String strExamDelete) {
        this.strExamDelete = strExamDelete;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getScorePlay() {
        return scorePlay;
    }

    public void setScorePlay(int scorePlay) {
        this.scorePlay = scorePlay;
    }

    public int getScoreOntime() {
        return scoreOntime;
    }

    public void setScoreOntime(int scoreOntime) {
        this.scoreOntime = scoreOntime;
    }

    public int getScoreTest() {
        return scoreTest;
    }

    public void setScoreTest(int scoreTest) {
        this.scoreTest = scoreTest;
    }

    public int getScoreExam() {
        return scoreExam;
    }

    public void setScoreExam(int scoreExam) {
        this.scoreExam = scoreExam;
    }

    public int getScoreCredit() {
        return scoreCredit;
    }

    public void setScoreCredit(int scoreCredit) {
        this.scoreCredit = scoreCredit;
    }

    public String getScoreCreateDate() {
        return strScoreCreateDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param scoreCreateDate 数据库取添加日期数据
     */
    public void setScoreCreateDate(Date scoreCreateDate) {
        this.strScoreCreateDate=DateUtil.formatDate(scoreCreateDate, "yyyy-MM-dd");
        this.scoreCreateDate = scoreCreateDate;
    }

    public String getModifyPerson() {
        return modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    public String getModifyDate() {
        return strModifyDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param modifyDate 数据库取添加日期数据
     */
    public void setModifyDate(Date modifyDate) {
        this.strModifyDate=DateUtil.formatDate(modifyDate, "yyyy-MM-dd");
        this.modifyDate = modifyDate;
    }

    public int getScoreDelete() {
        return scoreDelete;
    }

    public void setScoreDelete(int scoreDelete) {
        this.scoreDelete = scoreDelete;
    }
    
    public String getStrScoreCreateDate() {
        return strScoreCreateDate;
    }

    public String getStrModifyDate() {
        return strModifyDate;
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

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScoreModel [scoreId=" + scoreId + ", scorePlay=" + scorePlay + ", scoreOntime=" + scoreOntime
                + ", scoreTest=" + scoreTest + ", scoreExam=" + scoreExam + ", scoreCredit=" + scoreCredit
                + ", scoreCreateDate=" + scoreCreateDate + ", modifyPerson=" + modifyPerson + ", modifyDate="
                + modifyDate + ", courseId=" + courseId + ", courseName=" + courseName + ", scoreDelete=" + scoreDelete
                + "]";
    }
    
}
