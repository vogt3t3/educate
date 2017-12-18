package com.education.dao;

import com.education.model.ClassEvaluate;

/**
 * 课程评价
 * @author 刘帅
 *
 */
public interface ClassEvaluateDao {
    
    /**
     * 添加课程评价
     * @param 课程评价类
     */
    int addEvaluate(ClassEvaluate evaluate);
}
