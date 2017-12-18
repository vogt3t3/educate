package com.education.model;

import java.io.Serializable;

/**
 * 题库
 * @author 赵睿慷
 *
 */
public class StoreModel implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 题库编号
     */
    private int storeId;
    /**
     * 题库名称
     */
    private String storeName;
    /**
     * 题库说明
     */
    private String storeExplain;
    /**
     * 删除状态
     */
    private int storeDelete;
    public int getStoreId() {
        return storeId;
    }
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreExplain() {
        return storeExplain;
    }
    public void setStoreExplain(String storeExplain) {
        this.storeExplain = storeExplain;
    }
    public int getStoreDelete() {
        return storeDelete;
    }
    public void setStoreDelete(int storeDelete) {
        this.storeDelete = storeDelete;
    }
    @Override
    public String toString() {
        return "StoreModel [storeId=" + storeId + ", storeName=" + storeName + ", storeExplain=" + storeExplain
                + ", storeDelete=" + storeDelete + "]";
    }
    
    
}
