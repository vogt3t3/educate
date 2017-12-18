package com.education.service;

import com.education.model.ClassEvaluate;

/**
 * 课程评价服务类
 * @author 刘帅
 *
 */
public interface IEvaluateService {

    /**
     * 添加课程评价
     * @param 课程评价类
     * @return 返回影响的行数
     */
    int addEvaluate(ClassEvaluate evaluate);
}
