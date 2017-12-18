package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 选择题表
 * @author 赵睿慷
 *
 */
public class SelectModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 题目编号
     */
    private int selectId;
    /**
     * 题目名称
     */
    private String selectName;
    /**
     * 选项A
     */
    private String selectA;
    /**
     * 选项B
     */
    private String selectB;
    /**
     * 选项C
     */
    private String selectC;
    /**
     * 选项D
     */
    private String selectD;
    /**
     * 答案
     */
    private String selectAnswer;
    /**
     * 分值
     */
    private int selectPoint;
    /**
     * 录入时间
     */
    private Date selectAddtime;
    
    /**
     * String类型录入时间
     */
    private String selectAddtimeStr;
    /**
     * 修改时间(如果加上select就会命名过长)
     */
    private Date modifyDate;
    /**
     * String类型修改时间(如果加上select就会命名过长)
     */
    private String modifyDateStr;
    /**
     * 修改人(如果加上select就会命名过长)
     */
    private String modifyPerson;
    /**
     * 修改状态
     */
    private int selectDelete;
    public int getSelectId() {
        return selectId;
    }
    public void setSelectId(int selectId) {
        this.selectId = selectId;
    }
    public String getSelectName() {
        return selectName;
    }
    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }
    public String getSelectA() {
        return selectA;
    }
    public void setSelectA(String selectA) {
        this.selectA = selectA;
    }
    public String getSelectB() {
        return selectB;
    }
    public void setSelectB(String selectB) {
        this.selectB = selectB;
    }
    public String getSelectC() {
        return selectC;
    }
    public void setSelectC(String selectC) {
        this.selectC = selectC;
    }
    public String getSelectD() {
        return selectD;
    }
    public void setSelectD(String selectD) {
        this.selectD = selectD;
    }
    public String getSelectAnswer() {
        return selectAnswer;
    }
    public void setSelectAnswer(String selectAnswer) {
        this.selectAnswer = selectAnswer;
    }
    public int getSelectPoint() {
        return selectPoint;
    }
    public void setSelectPoint(int selectPoint) {
        this.selectPoint = selectPoint;
    }
    public Date getSelectAddtime() {
        return selectAddtime;
    }
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param selectAddtime 数据库取添加日期数据
     */
    public void setSelectAddtime(Date selectAddtime) {
        this.selectAddtime = selectAddtime;
        this.selectAddtimeStr = DateUtil.formatDate(selectAddtime, "yyyy-MM-dd HH:mm:ss");
    }
    public String getSelectAddtimeStr() {
        return selectAddtimeStr;
    }
    public Date getModifyDate() {
        return modifyDate;
    }
    
    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param modifyDate 数据库取修改日期数据
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        this.modifyDateStr = DateUtil.formatDate(modifyDate, "yyyy-MM-dd HH:mm:ss");
    }
    public String getModifyDateStr() {
        return modifyDateStr;
    }
    public String getModifyPerson() {
        return modifyPerson;
    }
    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }
    public int getSelectDelete() {
        return selectDelete;
    }
    public void setSelectDelete(int selectDelete) {
        this.selectDelete = selectDelete;
    }
    @Override
    public String toString() {
        return "SelectModel [selectId=" + selectId + ", selectName=" + selectName + ", selectA=" + selectA
                + ", selectB=" + selectB + ", selectC=" + selectC + ", selectD=" + selectD + ", selectAnswer="
                + selectAnswer + ", selectPoint=" + selectPoint + ", selectAddtime=" + selectAddtime
                + ", selectAddtimeStr=" + selectAddtimeStr + ", modifyDate=" + modifyDate + ", modifyDateStr="
                + modifyDateStr + ", modifyPerson=" + modifyPerson + ", selectDelete=" + selectDelete + "]";
    }
}
