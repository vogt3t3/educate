package com.education.service.exception;

import com.education.model.ErrorCode;

/**
 * 自定义异常
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException{
    
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
