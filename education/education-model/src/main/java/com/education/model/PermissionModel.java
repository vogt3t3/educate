package com.education.model;

import java.io.Serializable;

/**
 * 权限实体，用来做shiro权限
 * 
 * @author 杨振欣
 *
 */
public class PermissionModel implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 权限编号
     */
    private int permissionId;
    /**
     * 权限名称
     */
    private String permissionName;
    /**
     * 权限类型
     */
    private String permissionType;
    /**
     * 权限url
     */
    private String permissionUrl;
    /**
     * 所需权限
     */
    private String permissionCode;
    
    /**
     * 删除状态
     */
    private int permissionDelete;

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public int getPermissionDelete() {
        return permissionDelete;
    }

    public void setPermissionDelete(int permissionDelete) {
        this.permissionDelete = permissionDelete;
    }

    @Override
    public String toString() {
        return "PermissionModel [permissionId=" + permissionId + ", permissionName=" + permissionName
                + ", permissionType=" + permissionType + ", permissionUrl=" + permissionUrl + ", permissionCode="
                + permissionCode + ", permissionDelete=" + permissionDelete + "]";
    }
    
    
}
