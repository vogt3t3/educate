package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 考试信息模型
 * 
 * @author ZHAORUN
 *
 */
public class ExamInf implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 考试信息编号
     */
    private int examId;
    /**
     * 考试地点
     */
    private String examPlace;
    /**
     * 考试时间 Date
     */
    private Date examTime;
    /**
     * 考试时间 String
     */
    private String strExamTime;
    /**
     * 预约时间 Date
     */
    private Date examAppointTime;
    /**
     * 预约时间 String
     */
    private String strExamAppointTime;
    /**
     * 考试形式 
     */
    private String examForm;
    /**
     * 发布时间 Date
     */
    private Date examAddtime;
    /**
     * 发布时间 String
     */
    private String strExamAddtime;
    /**
     * 考试信息修改人
     */
    private String examMotifyPerson;
    /**
     * 修改时间 Date
     */
    private Date examMotifyDate;
    /**
     * 修改时间 String
     */
    private String strExamMotifyDate;
    /**
     * 删除状态
     */
    private int examDelete;

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamPlace() {
        return examPlace;
    }

    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.strExamTime=DateUtil.formatDate(examTime,"yyyy-MM-dd");
        this.examTime = examTime;
    }

    public String getStrExamTime() {
        return strExamTime;
    }

    public Date getExamAppointTime() {
        return examAppointTime;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param examAppointTime 数据库取添加日期数据
     */
    public void setExamAppointTime(Date examAppointTime) {
        this.strExamAddtime=DateUtil.formatDate(examAppointTime, "yyyy-MM-dd");
        this.examAppointTime = examAppointTime;
    }

    public String getStrExamAppointTime() {
        return strExamAppointTime;
    }

    public String getExamForm() {
        return examForm;
    }

    public void setExamForm(String examForm) {
        this.examForm = examForm;
    }

    public Date getExamAddtime() {
        return examAddtime;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param examAddtime 数据库取添加日期数据
     */
    public void setExamAddtime(Date examAddtime) {
        this.strExamAddtime=DateUtil.formatDate(examAddtime, "yyyy-MM-dd");
        this.examAddtime = examAddtime;
    }

    public String getStrExamAddtime() {
        return strExamAddtime;
    }

    public String getExamMotifyPerson() {
        return examMotifyPerson;
    }

    public void setExamMotifyPerson(String examMotifyPerson) {
        this.examMotifyPerson = examMotifyPerson;
    }

    public Date getExamMotifyDate() {
        return examMotifyDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param examMotifyDate 数据库取添加日期数据
     */
    public void setExamMotifyDate(Date examMotifyDate) {
        this.strExamMotifyDate=DateUtil.formatDate(examMotifyDate, "yyyy-MM-dd");
        this.examMotifyDate = examMotifyDate;
    }

    public String getStrExamMotifyDate() {
        return strExamMotifyDate;
    }

    public int getExamDelete() {
        return examDelete;
    }

    public void setExamDelete(int examDelete) {
        this.examDelete = examDelete;
    }

}
