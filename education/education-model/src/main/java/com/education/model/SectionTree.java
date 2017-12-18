package com.education.model;

import java.io.Serializable;
import java.util.List;

/**
 * 章节管理前台所需tree实体
 * 
 * @author 杨振欣
 *
 */
public class SectionTree implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 节点编号
     */
    private int id;
    /**
     * 节点名称
     */
    private String label;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 视频的编号
     */
    private int videoId;
    /**
     * 子节点数组
     */
    private List<SectionTree> children;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<SectionTree> getChildren() {
        return children;
    }

    public void setChildren(List<SectionTree> children) {
        this.children = children;
    }

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	@Override
	public String toString() {
		return "SectionTree [id=" + id + ", label=" + label + ", courseName=" + courseName + ", children=" + children
				+ "]";
	}
	
}
