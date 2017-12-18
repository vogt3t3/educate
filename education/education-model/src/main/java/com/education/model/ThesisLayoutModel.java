package com.education.model;

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;

/**
 * 论文格式表
 * @author 刘帅
 *
 */
public class ThesisLayoutModel implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 论文格式表编号
     */
    private int layoutId;
    
    /**
     * 论文规范名称
     */
    private String layoutName;
    
    /**
     * 论文格式要求文件的地址
     */
    private String layoutContent;
    
    /**
     * 上传日期
     */
    private Date layoutUpdate;
    
    /**
     * 上传日期的字符串
     */
    private String layoutUpdateStr;

    /**
     * 删除状态
     */
    private int layoutDelete;

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public String getLayoutContent() {
        return layoutContent;
    }

    public void setLayoutContent(String layoutContent) {
        this.layoutContent = layoutContent;
    }

    /**
     * 数据库传输用Date
     * 前台取date用string
     * @param layoutUpdate 数据库取添加日期数据
     */
    public void setLayoutUpdate(Date layoutUpdate) {
        this.layoutUpdate = layoutUpdate;
        this.layoutUpdateStr = DateUtil.formatDate(layoutUpdate, "yyyy-MM-dd hh:mm:ss");
    }
    
    
    public String getLayoutUpdateStr() {
        return layoutUpdateStr;
    }

    public int getLayoutDelete() {
        return layoutDelete;
    }

    public void setLayoutDelete(int layoutDelete) {
        this.layoutDelete = layoutDelete;
    }
    
    public Date getLayoutUpdate() {
        return layoutUpdate;
    }
}
