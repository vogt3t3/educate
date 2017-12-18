package com.education.exception;

import com.education.model.ErrorCode;

/**
 * 自定义异常
 * @author Administrator
 *
 */
public class ServiceException extends RuntimeException{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 错误返回类型实体
     */
    private ErrorCode errorCode;
    public ServiceException(ErrorCode errorCode){
        
        this.errorCode=errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    
}
