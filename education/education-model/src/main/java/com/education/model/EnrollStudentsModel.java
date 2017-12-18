package com.education.model;

import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 招生计划实体模型
 * @author ZHAORUN
 *
 */

public class EnrollStudentsModel implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    /**
     *  招生编号  年份+专业号
     *  
     */
    private int enrollStudentId;
    /**
     * 学费
     */
    private double enrollTuition;
    /**
     * 招生人数
     */
    private int enrollStudentNum;
    /**
     * 学制
     */
    private String enrollEduSystem;
    /**
     * 招生区域
     */
    private String enrollArea;
    /**
     * 招生计划创建时间Date
     */
    private Date enrollCreateDate;
    /**
     * 招生计划创建时间String
     */
    private String strEnrollCreateDate;
    /**
     * 招生形式
     */
    private String enrollModel;
    /**
     * 招生计划最近修改人
     */
    private String enrollModifyPerson;
    /**
     * 招生计划修改时间 Date
     */
    private Date enrollModifyDate;
    /**
     * 招生计划修改时间 String
     */
    private String strEnrollModifyDate;
    
    /**
     * 招生计划状态
     * 1为未删除状态，0为已删除状态
     */
    private int enrollDelete;

    public int getEnrollStudentId() {
        return enrollStudentId;
    }

    public void setEnrollStudentId(int enrollStudentId) {
        this.enrollStudentId = enrollStudentId;
    }

    

    public double getEnrollTuition() {
        return enrollTuition;
    }

    public void setEnrollTuition(double enrollTuition) {
        this.enrollTuition = enrollTuition;
    }

    public int getEnrollStudentNum() {
        return enrollStudentNum;
    }

    public void setEnrollStudentNum(int enrollStudentNum) {
        this.enrollStudentNum = enrollStudentNum;
    }

    public String getEnrollEduSystem() {
        return enrollEduSystem;
    }

    public void setEnrollEduSystem(String enrollEduSystem) {
        this.enrollEduSystem = enrollEduSystem;
    }

    public String getEnrollArea() {
        return enrollArea;
    }

    public void setEnrollArea(String enrollArea) {
        this.enrollArea = enrollArea;
    }

    public Date getEnrollCreateDate() {
        return enrollCreateDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param enrollCreateDate 数据库取添加日期数据
     */
    public void setEnrollCreateDate(Date enrollCreateDate) {
        this.strEnrollCreateDate=DateUtil.formatDate(enrollCreateDate, "yyyy-MM-dd");
        this.enrollCreateDate = enrollCreateDate;
    }

    public String getStrEnrollCreateDate() {
        return strEnrollCreateDate;
    }

    public String getEnrollModel() {
        return enrollModel;
    }

    public void setEnrollModel(String enrollModel) {
        this.enrollModel = enrollModel;
    }

    public String getEnrollModifyPerson() {
        return enrollModifyPerson;
    }

    public void setEnrollModifyPerson(String enrollModifyPerson) {
        this.enrollModifyPerson = enrollModifyPerson;
    }

    public Date getEnrollModifyDate() {
        return enrollModifyDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param enrollModifyDate 数据库取添加日期数据
     */
    public void setEnrollModifyDate(Date enrollModifyDate) {
        this.strEnrollModifyDate=DateUtil.formatDate(enrollModifyDate, "yyyy-MM-dd");
        this.enrollModifyDate = enrollModifyDate;
    }

    public String getStrDnrollModifyDate() {
        return strEnrollModifyDate;
    }


    public int getEnrollDelete() {
        return enrollDelete;
    }

    public String getStrEnrollModifyDate() {
        return strEnrollModifyDate;
    }

    public void setEnrollDelete(int enrollDelete) {
        this.enrollDelete = enrollDelete;
    }
    
}
