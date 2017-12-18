package com.education.model;

import java.io.Serializable;

/**
 * @author 李志鹏
 *
 */
public class SectionOption implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 下拉框的章节Id;
     */
    private int value;
    
    /**
     * 下拉框的章节名称;
     */
    private String label;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
    
    
    
}
