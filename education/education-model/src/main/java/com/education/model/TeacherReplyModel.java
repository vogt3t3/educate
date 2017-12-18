package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 教师回复
 * 
 * @author 赵睿慷
 *
 */
public class TeacherReplyModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 回复表编号
     */
    private int replyId;
    /**
     * 老师编号
     */
    private int teacherId;
    /**
     * 疑问编号
     */
    private int quizid;
    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 回复内容
     */
    private String replyContent;
    /**
     * 删除状态
     */
    private int replyDelete;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getReplyDelete() {
        return replyDelete;
    }

    /**
     * 数据库传输用Date 前台取date用string
     * 
     * @param replyDelete
     *            数据库取回复日期数据
     */
    public void setReplyDelete(int replyDelete) {
        this.replyDelete = replyDelete;

    }
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }
}
