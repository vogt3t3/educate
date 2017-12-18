package com.education.model;

import java.io.Serializable;
import java.util.List;

/**扩展了课程编号 课程名称 章节名称 章节编号
 * 
 * @author 判断题下拉框
 *
 */
public class Judge implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 课程Id
     */
    private int value;
    /**
     * 课程名称
     */
    private String label;
    /**
     * 前端子类的章节试题类（目的是取章节名称和章节id）
     */
    private List<SectionOption> children;
    
    
    
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
    public List<SectionOption> getChildren() {
        return children;
    }
    public void setChildren(List<SectionOption> children) {
        this.children = children;
    }
    
    
    
    
    
    
   
 
    
    

}
