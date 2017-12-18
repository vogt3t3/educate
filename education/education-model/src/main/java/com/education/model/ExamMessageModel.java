package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * @author 考试信息实体类
 *
 */
public class ExamMessageModel implements Serializable {
    /**
     * 
     */
 
    /**
     * 考试信息编号
     */
    private int examid;
    /**
     * 考试地点
     */
    private String examplace;
    /**
     * 考试时间
     */
    private Date examtime;
    /**
     * 考试时间(String)
     */
    private String examtimestr;
    /**
     * 预约时间
     */
    private Date examappointtime;
    /**
     * 预约时间(String)
     */
    private String examappointtimestr;
    /**
     * 考试形式
     */
    private String examform;
    /**
     * 发布时间
     */
    private Date examaddtime;
    /**
     * 修改人
     */
    private int exammotifyperson;
    /**
     * 修改时间
     */
    private Date exammotifydate;
    /**
     * 删除状态
     */
    private int examdelete;
    /**
     * 教师id
     */
    private int teacherid;
    /**
     * 教师姓名
     */
    private String teachername;
    /**
     * 课程id
     */
    private int courseid;
    /**
     * 课程名称
     */
    private String coursename;

    public ExamMessageModel(int examid, String examplace, Date examtime, Date examappointtime, String examform) {
        super();
        this.examid = examid;
        this.examplace = examplace;
        this.examtime = examtime;
        this.examappointtime = examappointtime;
        this.examform = examform;
    }

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public String getExamplace() {
        return examplace;
    }

    public void setExamplace(String examplace) {
        this.examplace = examplace;
    }

    public Date getExamtime() {
        return examtime;
    }

 
    /**
     * @param examtime 输入的值
     */
    public void setExamtime(Date examtime) {
        this.examtime = examtime;
        this.examtimestr = DateUtil.formatDate(examtime, "yyyy-MM-dd");
    }

    public String getExamtimestr() {
        return examtimestr;
    }

    public Date getExamappointtime() {

        return examappointtime;
    }

    /**
     * @param examappointtime 添加的值
     */
    public void setExamappointtime(Date examappointtime) {
        this.examappointtime = examappointtime;
        this.examappointtimestr = DateUtil.formatDate(examappointtime, "yyyy-MM-dd");
       
    }

    public String getExamform() {
        return examform;
    }

    public void setExamform(String examform) {
        this.examform = examform;
    }

    public Date getExamaddtime() {
        return examaddtime;
    }

    public void setExamaddtime(Date examaddtime) {
        this.examaddtime = examaddtime;
    }

    public int getExammotifyperson() {
        return exammotifyperson;
    }

    public void setExammotifyperson(int exammotifyperson) {
        this.exammotifyperson = exammotifyperson;
    }

    public Date getExammotifydate() {
        return exammotifydate;
    }

    public void setExammotifydate(Date exammotifydate) {
        this.exammotifydate = exammotifydate;
    }

    public int getExamdelete() {
        return examdelete;
    }

    public void setExamdelete(int examdelete) {
        this.examdelete = examdelete;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }



    public ExamMessageModel() {
    }

    public String getExamappointtimestr() {
        return examappointtimestr;
    }

    @Override
    public String toString() {
        return "ExamMessageModel [examid=" + examid + ", examplace=" + examplace + ", examtime=" + examtime + ", examtimestr=" + examtimestr + ", examappointtime=" + examappointtime
                + ", examappointtimestr=" + examappointtimestr + ", examform=" + examform + ", examaddtime=" + examaddtime + ", exammotifyperson=" + exammotifyperson + ", exammotifydate="
                + exammotifydate + ", examdelete=" + examdelete + ", teacherid=" + teacherid + ", teachername=" + teachername + ", courseid=" + courseid + ", coursename=" + coursename + "]";
    }
}
