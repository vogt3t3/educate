package com.education.model;

import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 章节表实体类
 * @author FYM
 *
 */
public class SectionModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     *章节编号 
     */
    private int sectionId;
    /**
     * 章节名称
     */
    private String sectionName;
    /**
     * 发布时间
     */
    private Date secAddtime;
    /**
     * 发布时间（String）
     */
    private String secAddtimeStr;
    /**
     * 修改人
     */
    private String secModifyName;
    /**
     * 修改时间
     */
    private Date secModifyDate;
    /**
     * 修改时间（String）
     */
    private String secModifyDateStr;
    /**
     * 删除状态
     */
    private int sectionDel;
    public int getSectionId() {
        return sectionId;
    }
    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
    public String getSectionName() {
        return sectionName;
    }
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
    public Date getSecAddtime() {
        return secAddtime;
    }
    /**
     * 数据库传输数据为Date类型
     * 前台取时用字符串
     * @param secAddtime 数据库取的日期数据
     */
    public void setSecAddtime(Date secAddtime) {
        this.secAddtimeStr=DateUtil.formatDate(secAddtime, "yyyy-MM-dd HH:mm:ss");
        this.secAddtime = secAddtime;
    }
    public String getSecAddtimeStr() {
        return secAddtimeStr;
    }
    public String getSecModifyName() {
        return secModifyName;
    }
    public void setSecModifyName(String secModifyName) {
        this.secModifyName = secModifyName;
    }
    public Date getSecModifyDate() {
        return secModifyDate;
    }
    /**
     * 数据库传输数据为Date类型
     * 前台取时用字符串
     * @param secModifyDate 数据库取的日期数据
     */
    public void setSecModifyDate(Date secModifyDate) {
        this.secModifyDateStr=DateUtil.formatDate(secModifyDate, "yyyy-MM-dd HH:mm:ss");
        this.secModifyDate = secModifyDate;
    }
    public String getSecModifyDateStr() {
        return secModifyDateStr;
    }
    public int getSectionDel() {
        return sectionDel;
    }
    public void setSectionDel(int sectionDel) {
        this.sectionDel = sectionDel;
    }
    @Override
    public String toString() {
        return "SectionModel [sectionId=" + sectionId + ", sectionName=" + sectionName + ", secAddtime=" + secAddtime
                + ", secAddtimeStr=" + secAddtimeStr + ", secModifyName=" + secModifyName + ", secModifyDate="
                + secModifyDate + ", secModifyDateStr=" + secModifyDateStr + ", sectionDel=" + sectionDel + "]";
    }
    
}
