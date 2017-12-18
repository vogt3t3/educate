package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 视频提问(学生)
 * 
 * @author Administrator
 *
 */
public class StudentQuizModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 提问者编号
     */
    private int quizId;
    /**
     * 视频id
     */
    private int videoId;
    /**
     * 提问日期
     */
    private Date quizDate;
    /**
     * 提问日期(String)
     */
    private String quizDateStr;
    /**
     * 提问内容
     */
    private String quizContent;
    /**
     * 删除状态
     */
    private int quizDelete;

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    /**
     * 回复表编号
     */
    private int replyid;
    public TeacherReplyModel getTl() {
        return tl;
    }

    public void setTl(TeacherReplyModel tl) {
        this.tl = tl;
    }

    /**
     *  对应教师回复表
     */
    private TeacherReplyModel tl;
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Date getQuizDate() {
        return quizDate;
    }

    /**
     * 数据库传输用Date 前台取date用string
     * 
     * @param quizDate
     *            数据库提问日期数据
     */
    public void setQuizDate(Date quizDate) {
        this.quizDate = quizDate;
        this.quizDateStr = DateUtil.formatDate(quizDate, "yyyy-MM-dd HH:mm:ss");
    }

    public String getQuizContent() {
        return quizContent;
    }

    public void setQuizContent(String quizContent) {
        this.quizContent = quizContent;
    }

    public int getQuizDelete() {
        return quizDelete;
    }

    public void setQuizDelete(int quizDelete) {
        this.quizDelete = quizDelete;
    }

    public String getQuizDateStr() {
        return quizDateStr;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "StudentQuizModel [quizId=" + quizId + ", quizDate=" + quizDate + ", quizDateStr=" + quizDateStr + ", quizContent=" + quizContent + ", quizDelete=" + quizDelete + "]";
    }

}
