package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 判断题模型
 * 
 * @author ZHAORUN
 *
 */
public class JudgeTopic implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 题目编号
     */
    private int judgeId;
    /**
     * 题目名称
     */
    private String judgeName;
    /**
     * 选项1
     */
    private String judgeOne;
    /**
     * 选项2
     */
    private String judgeTwo;
    /**
     * 答案
     */
    private String judgeAnswer;
    /**
     * 录题人
     */
    private String judgeAdduser;
    /**
     * 修改人
     */
    private String judgeModifyPerson;
    /**
     * 录题时间 Date
     */
    private Date judgeAddtime;
    /**
     * 录题时间 String
     */
    private String strJudgeAddtime;
    /**
     * 修改时间 String
     */
    private String strJudgeModifyDate;
    /**
     * 修改时间 Date
     */
    private Date judgeModifyDate;
    /**
     * 分值
     */
    private int judgePoint;
    /**
     * 删除状态
     */
    private int judgeDelete;

    public int getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(int judgeId) {
        this.judgeId = judgeId;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    public String getJudgeOne() {
        return judgeOne;
    }

    public void setJudgeOne(String judgeOne) {
        this.judgeOne = judgeOne;
    }

    public String getJudgeTwo() {
        return judgeTwo;
    }

    public void setJudgeTwo(String judgeTwo) {
        this.judgeTwo = judgeTwo;
    }

    public String getJudgeAnswer() {
        return judgeAnswer;
    }

    public void setJudgeAnswer(String judgeAnswer) {
        this.judgeAnswer = judgeAnswer;
    }

    public String getJudgeAdduser() {
        return judgeAdduser;
    }

    public void setJudgeAdduser(String judgeAdduser) {
        this.judgeAdduser = judgeAdduser;
    }

    public String getJudgeModifyPerson() {
        return judgeModifyPerson;
    }

    public void setJudgeModifyPerson(String judgeModifyPerson) {
        this.judgeModifyPerson = judgeModifyPerson;
    }

    public Date getJudgeAddtime() {
        return judgeAddtime;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param judgeAddtime 数据库取添加日期数据
     */
    public void setJudgeAddtime(Date judgeAddtime) {
        this.strJudgeAddtime=DateUtil.formatDate(judgeAddtime, "yyyy-MM-dd");
        this.judgeAddtime = judgeAddtime;
    }

    public String getStrJudgeAddtime() {
        return strJudgeAddtime;
    }

    public String getStrJudgeModifyDate() {
        return strJudgeModifyDate;
    }

    public Date getJudgeModifyDate() {
        return judgeModifyDate;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param judgeModifyDate 数据库取添加日期数据
     */
    public void setJudgeModifyDate(Date judgeModifyDate) {
        this.strJudgeModifyDate=DateUtil.formatDate(judgeModifyDate, "yyyy-MM-dd");
        this.judgeModifyDate = judgeModifyDate;
    }

    public int getJudgePoint() {
        return judgePoint;
    }

    public void setJudgePoint(int judgePoint) {
        this.judgePoint = judgePoint;
    }

    public int getJudgeDelete() {
        return judgeDelete;
    }

    public void setJudgeDelete(int judgeDelete) {
        this.judgeDelete = judgeDelete;
    }

}
