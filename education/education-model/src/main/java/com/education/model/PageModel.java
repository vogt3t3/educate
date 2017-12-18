package com.education.model;

import java.io.Serializable;

/**
 * 权限管理分页实体
 * 
 * @author 杨振欣
 *
 */
public class PageModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private Integer pageNo;

    /**
     * 所取数据数
     */
    private Integer pageSize;
    /**
     * 权限编号
     */
    private Integer roleId;
    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "PageModel [pageNo=" + pageNo + ", pageSize=" + pageSize + ", roleId=" + roleId + "]";
	}



}
