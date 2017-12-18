package com.education.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.education.util.DateUtil;

/**
 * 学生对该课程成绩的疑问的申请记录类
 * 
 * @author shenZhongzheng
 *
 */
@Component
public class Dissent implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 异议表编号
     */
    private int dissentId;

    /**
     * 异议说明
     */
    private String dissentContent;

    /**
     * 提出时间
     */
    private Date dissentDate;
    /**
     * 提出时间 --格式 yyyy-MM-dd
     */
    private String dissentDateStr;

    /**
     * 审核状态
     */
    private int dissentCheck;
    /**
     * 删除状态
     */
    private int dissentDelete;

    public int getDissentId() {
        return dissentId;
    }

    public void setDissentId(int dissentId) {
        this.dissentId = dissentId;
    }

    public String getDissentContent() {
        return dissentContent;
    }

    public void setDissentContent(String dissentContent) {
        this.dissentContent = dissentContent;
    }

    public Date getDissentDate() {
        return dissentDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string 
     * @param dissentDate 数据库取回复日期数据
     */
    public void setDissentDate(Date dissentDate) {
        this.dissentDate = dissentDate;
        this.dissentDateStr = DateUtil.formatDate(dissentDate, "yyyy-MM-dd");
    }

    public String getDissentDateStr() {
        return dissentDateStr;
    }

    public int getDissentCheck() {
        return dissentCheck;
    }

    public void setDissentCheck(int dissentCheck) {
        this.dissentCheck = dissentCheck;
    }

    public int getDissentDelete() {
        return dissentDelete;
    }

    public void setDissentDelete(int dissentDelete) {
        this.dissentDelete = dissentDelete;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
