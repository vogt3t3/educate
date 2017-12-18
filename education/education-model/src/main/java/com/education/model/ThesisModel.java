package com.education.model;

import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 论文表
 * 
 * @author 刘帅
 *
 */
public class ThesisModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 论文表编号
     */
    private int thesisId;
    
    /**
     * 学生编号
     */
    private int studentId;

    /**
     * 论文题目
     */
    private String thesisTitle;

    /**
     * 论文地址
     */
    private String thesisAddress;
    
    /**
     * 论文成绩
     */
    private String thesisScore;

    /**
     * 提交日期
     */
    private Date thesisDate;

    /**
     * 提交日期的字符串
     */
    private String thesisDateStr;

    /**
     * 审核状态
     */
    private int thesisState;
    
    /**
     * 审核状态字符串
     */
    private String thesisStateStr;

    /**
     * 删除状态
     */
    private int thesisDelete;

    public int getThesisId() {
        return thesisId;
    }

    public void setThesisId(int thesisId) {
        this.thesisId = thesisId;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getThesisAddress() {
        return thesisAddress;
    }

    public void setThesisAddress(String thesisAddress) {
        this.thesisAddress = thesisAddress;
    }

    public Date getThesisDate() {
        return thesisDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param thesisDate 数据库取添加日期数据
     */
    public void setThesisDate(Date thesisDate) {
        this.thesisDate = thesisDate;
        this.thesisDateStr = DateUtil.formatDate(thesisDate, "yyyy-MM-dd");
    }

    public String getThesisDateStr() {
        return thesisDateStr;
    }

    public int getThesisState() {
        return thesisState;
    }

    
    /**
     * 前台使用String接受数据
     * @param thesisState 数据库获取数据
     */
    public void setThesisState(int thesisState) {
        this.thesisState = thesisState;
        if (this.thesisState == 1) {
            this.thesisStateStr = "已审核";
        }
        if (this.thesisState == 0) {
            this.thesisStateStr = "未审核";
        }
    }

    public int getThesisDelete() {
        return thesisDelete;
    }

    public void setThesisDelete(int thesisDelete) {
        this.thesisDelete = thesisDelete;
    }

    public String getThesisScore() {
        return thesisScore;
    }

    public void setThesisScore(String thesisScore) {
        this.thesisScore = thesisScore;
    }

    public String getThesisStateStr() {
        return thesisStateStr;
    }

    public void setThesisStateStr(String thesisStateStr) {
        this.thesisStateStr = thesisStateStr;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

}
