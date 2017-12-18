package com.education.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 公告表实体类
 * @author FYM
 *
 */
public class NoticeModel extends TeacherModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 公告编号
     */
    private int noticeId;
    /**
     * 公告标题
     */
    private String noticeName;
    /**
     * 公告详情
     */
    private String noticeInfo;
    /**
     * 公告时间
     */
    private Date noticeDate;
    /**
     * 公告时间字符串
     */
    private String noticeDateStr;
    /**
     * 针对人群
     */
    private int noticeTarget;
    /**
     * 公告创建时间
     */
    private Date noticeCreateDate;
    /**
     * 公告创建时间字符串
     */
    private String notCreateDateStr;
    /**
     * 公告修改时间
     */
    private Date noticeModifyDate;
    /**
     * 公告修改时间字符串
     */
    private String notModifyDateStr;
    /**
     * 修改人
     */
    private String noticeModifyName;
    /**
     * 公告的删除状态
     */
    private int noticeDel;
    public int getNoticeId() {
        return noticeId;
    }
    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }
    public String getNoticeName() {
        return noticeName;
    }
    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }
    public String getNoticeInfo() {
        return noticeInfo;
    }
    public void setNoticeInfo(String noticeInfo) {
        this.noticeInfo = noticeInfo;
    }
    public Date getNoticeDate() {
        return noticeDate;
    }
    /**
     * 数据库传输数据为Date类型
     * 前台取时用字符串 
     * @param noticeDate 数据库取的日期数据
     */
    public void setNoticeDate(Date noticeDate) {
        this.noticeDateStr=DateUtil.formatDate(noticeDate, "yyyy-MM-dd HH:mm:ss");
        this.noticeDate = noticeDate;
    }
    public String getNoticeDateStr() {
        return noticeDateStr;
    }
    
    /**
     * 数据库中Date转Str
     * @param noticeDateStr 前台取的日期数据
     * @throws ParseException 抛出异常
     */
    public void setNoticeDateStr(String noticeDateStr) throws ParseException {
        this.noticeDateStr = noticeDateStr;
        this.noticeDate = DateUtil.formatString(noticeDateStr, "yyyy-MM-dd");
    }
    /**
     * 数据库中Date转Str
     * @param notCreateDateStr 前台取的日期数据
     * @throws ParseException 抛出异常
     */
    public void setNotCreateDateStr(String notCreateDateStr) throws ParseException {
        this.notCreateDateStr = notCreateDateStr;
        this.noticeCreateDate = DateUtil.formatString(notCreateDateStr, "yyyy-MM-dd");
    }
    /**
     * 数据库中Date转Str
     * @param notModifyDateStr 前台取的日期数据
     * @throws ParseException 抛出异常
     */
    public void setNotModifyDateStr(String notModifyDateStr) throws ParseException {
        this.notModifyDateStr = notModifyDateStr;
        this.noticeModifyDate = DateUtil.formatString(notModifyDateStr, "yyyy-MM-dd");
    }
    
    public int getNoticeTarget() {
        return noticeTarget;
    }
    public void setNoticeTarget(int noticeTarget) {
        this.noticeTarget = noticeTarget;
    }
    public Date getNoticeCreateDate() {
        return noticeCreateDate;
    }
    /**
     * 数据库传输数据为Date类型
     * 前台取时用字符串 
     * @param noticeCreateDate 数据库取的日期数据
     */
    public void setNoticeCreateDate(Date noticeCreateDate) {
        this.notCreateDateStr=DateUtil.formatDate(noticeCreateDate, "yyyy-MM-dd HH:mm:ss");
        this.noticeCreateDate = noticeCreateDate;
    }
    public String getNotCreateDateStr() {
        return notCreateDateStr;
    }
    public Date getNoticeModifyDate() {
        return noticeModifyDate;
    }
    /**
     * 数据库传输数据为Date类型
     * 前台取时用字符串 
     * @param noticeModifyDate 数据库取的日期数据
     */
    public void setNoticeModifyDate(Date noticeModifyDate) {
        this.notModifyDateStr=DateUtil.formatDate(noticeModifyDate, "yyyy-MM-dd HH:mm:ss");
        this.noticeModifyDate = noticeModifyDate;
    }
    public String getNotModifyDateStr() {
        return notModifyDateStr;
    }
    public String getNoticeModifyName() {
        return noticeModifyName;
    }
    public void setNoticeModifyName(String noticeModifyName) {
        this.noticeModifyName = noticeModifyName;
    }
    public int getNoticeDel() {
        return noticeDel;
    }
    public void setNoticeDel(int noticeDel) {
        this.noticeDel = noticeDel;
    }
    @Override
    public String toString() {
        return "NoticeModel [noticeId=" + noticeId + ", noticeName=" + noticeName + ", noticeInfo=" + noticeInfo
                + ", noticeDate=" + noticeDate + ", noticeDateStr=" + noticeDateStr + ", noticeTarget=" + noticeTarget
                + ", noticeCreateDate=" + noticeCreateDate + ", notCreateDateStr=" + notCreateDateStr
                + ", noticeModifyDate=" + noticeModifyDate + ", notModifyDateStr=" + notModifyDateStr
                + ", noticeModifyName=" + noticeModifyName + ", noticeDel=" + noticeDel + "]";
    }
    
}
