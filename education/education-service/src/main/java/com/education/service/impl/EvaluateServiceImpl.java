package com.education.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.education.dao.ClassEvaluateDao;
import com.education.model.ClassEvaluate;
import com.education.service.IEvaluateService;

/**
 * 课程评价服务层实现类
 * @author Administrator
 *
 */
public class EvaluateServiceImpl implements IEvaluateService {

    /**
     * 课程评价
     */
    @Autowired
    private ClassEvaluateDao classEvaluate;
    
    /**
     * 添加课程评价
     * @param 课程评价类
     * @return 返回影响的行数
     */
    public int addEvaluate(ClassEvaluate evaluate) {
        
        //通过前台传过来的课程名称查到其所对应的编号
        
        //调用dao层，添加课程评价
       int bool = classEvaluate.addEvaluate(evaluate);
        
        return bool;
    }

}
