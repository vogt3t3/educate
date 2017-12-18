package com.education.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.dao.MexamDao;
import com.education.model.ExamMessageModel;
import com.education.model.User;
import com.education.service.QueryExamPage;
import com.education.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author 信息服务层
 *
 */
@Service
public class QueryExamPageImpl implements QueryExamPage {

    /**
     * 注入接口
     */
    @Autowired
    private MexamDao mxdao;
    /**
     * 注入实体类
     */
    private ExamMessageModel ex;

    @Override
    public PageInfo<ExamMessageModel> pagenow(Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 5 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<ExamMessageModel> list = mxdao.queryExam();
        PageInfo<ExamMessageModel> page = new PageInfo<ExamMessageModel>(list);
        System.out.println(page);
        return page;
    }

    @Override
    public void addexam(ExamMessageModel el) throws Exception {
        mxdao.addResource(el);
    }

    @Override
    public int deleup(Integer eid) throws Exception {
        mxdao.deletExam(eid);
        return 0;
    }

}
