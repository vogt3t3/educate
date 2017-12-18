package com.education.model;

import java.io.Serializable;

/**
 * 报名须知实体类
 * 
 * @author 张建磊
 *
 */
public class Hregister implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 报名须知编号
     */
    private int applyKnowId;
    /**
     * 招生编号
     */
    private int enrollId;
    /**
     * 报名须知标题
     */
    private String applyKnowTitle;
    /**
     * 报名须知内容
     */
    private String applyKnowContent;
    /**
     * 删除状态
     */
    private int applyKnowDelete;
    public int getApplyKnowId() {
        return applyKnowId;
    }
    public void setApplyKnowId(int applyKnowId) {
        this.applyKnowId = applyKnowId;
    }
    public int getEnrollId() {
        return enrollId;
    }
    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
    }
    public String getApplyKnowTitle() {
        return applyKnowTitle;
    }
    public void setApplyKnowTitle(String applyKnowTitle) {
        this.applyKnowTitle = applyKnowTitle;
    }
    public String getApplyKnowContent() {
        return applyKnowContent;
    }
    public void setApplyKnowContent(String applyKnowContent) {
        this.applyKnowContent = applyKnowContent;
    }
    public int getApplyKnowDelete() {
        return applyKnowDelete;
    }
    public void setApplyKnowDelete(int applyKnowDelete) {
        this.applyKnowDelete = applyKnowDelete;
    }
    

}
