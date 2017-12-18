package com.education.model;

import java.io.Serializable;
import java.util.Date;
import com.education.util.DateUtil;

/**
 * 小节表实体类
 * @author FYM
 *
 */
public class PartSectionModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 小节编号
     */
    private int partId;
    
    /**
     * 小节编号名
     */
    private String partIdName;
    
   
    /**
     * 小节名称
     */
    private String partName;
    /**
     *访问次数 
     */
    private int partFrequence;
    /**
     * 发布时间
     */
    private Date partAddtime;
    /**
     * 发布时间（String）
     */
    private String partAddtimeStr;
    /**
     * 修改人
     */
    private String partModifyName;
    /**
     * 修改时间
     */
    private Date partModifyDate;
    /**
     * 修改时间（String）
     */
    private String partModifyDateStr;
    /**
     * 删除状态
     */
    private int partDel;
    public int getPartId() {
        return partId;
    }
    public void setPartId(int partId) {
        this.partId = partId;
    }
    public String getPartName() {
        return partName;
    }
    public void setPartName(String partName) {
        this.partName = partName;
    }
    public int getPartFrequence() {
        return partFrequence;
    }
    public void setPartFrequence(int partFrequence) {
        this.partFrequence = partFrequence;
    }
    public Date getPartAddtime() {
        return partAddtime;
    }
    /**
     * 数据库传输数据为Date类型
     * 前台取时用字符串
     * @param partAddtime 数据库取的日期数据
     */
    public void setPartAddtime(Date partAddtime) {
        this.partAddtimeStr=DateUtil.formatDate(partAddtime, "yyyy-MM-dd HH:mm:ss");
        this.partAddtime = partAddtime;
    }
    public String getPartAddtimeStr() {
        return partAddtimeStr;
    }
    public String getPartModifyName() {
        return partModifyName;
    }
    public void setPartModifyName(String partModifyName) {
        this.partModifyName = partModifyName;
    }
    public Date getPartModifyDate() {
        return partModifyDate;
    }
    /**
     * 数据库传输数据为Date类型
     * 前台取时用字符串
     * @param partModifyDate 数据库取的日期数据
     */
    public void setPartModifyDate(Date partModifyDate) {
        this.partModifyDateStr=DateUtil.formatDate(partModifyDate, "yyyy-MM-dd HH:mm:ss");
        this.partModifyDate = partModifyDate;
    }
    public String getPartModifyDateStr() {
        return partModifyDateStr;
    }
    public int getPartDel() {
        return partDel;
    }
    public void setPartDel(int partDel) {
        this.partDel = partDel;
    }
    
    public String getPartIdName() {
        return partIdName;
    }
    public void setPartIdName(String partIdName) {
        this.partIdName = partIdName;
    }
    
}
