package com.education.model;

import java.io.Serializable;

/**
 * 课件 - 资源id  扩展字段
 * @author 申忠正
 */
public class CoursewareResId extends Courseware implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * 资料编号
     */
    private int resourceId;
    /**
     * 资料名称
     */
    private String resourceName;
    
    public int getResourceId() {
        return resourceId;
    }
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    
}

