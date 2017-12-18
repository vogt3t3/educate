package com.education.student.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.education.service.exception.ServiceException;
import com.education.model.ErrorCode;

/**
 * 全局异常处理类
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@RestControllerAdvice
public class GlobExceptionHandle{
    
	   private static Logger MYLOGGER = LogManager.getLogger(GlobExceptionHandle.class.getName());
    /**
     * @param e 自定义异常
     * @return ErrorCode 错误代码实体
     */
    @ExceptionHandler(ServiceException.class)
    public ErrorCode handleException(ServiceException e){
    	e.printStackTrace();
        ErrorCode ec=e.getErrorCode();
        MYLOGGER.error("服务出现定义异常");
        return ec;    
    }
    
    /**
     * @param e 其他异常处理
     */
    @ExceptionHandler(Exception.class)
    public ErrorCode handleException(Exception e){
        e.printStackTrace();
    	 MYLOGGER.error("服务出现其他异常");
    	return ErrorCode.SERVER_ERROR;
    }
}