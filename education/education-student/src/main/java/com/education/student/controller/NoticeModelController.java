package com.education.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.NoticeModel;
import com.education.model.ResultDo;
import com.education.service.INoticeServiceApi;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



/**
 * 公告详情页面controller层
 * @author 赵睿慷
 *
 */
@Api(value="/api/student",description="公告详情")
@Controller
@RequestMapping("/api/student")
public class NoticeModelController {

    
    /**
     * 注入公告Service接口
     */
    @Reference
    private INoticeServiceApi insa;
    
    /**
     * 获取公告
     * @param pageSize   当前页条数
     * @param pageNum    总页数
     * @return 返回所有通知信息
     */
    @ApiOperation(notes="notices/select",httpMethod="GET",value="获取公告")
    @RequestMapping(path = "/notices/select" , method = RequestMethod.GET)
    @ResponseBody
    public ResultDo<Object> selectNoticeById(Integer pageSize, Integer pageNum){
        System.out.println("当前页是:"+pageNum);
        PageInfo<NoticeModel> page = insa.selectNoticeById(pageSize, pageNum);
        List<NoticeModel> list = page.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("noticeList", list);
        map.put("total", page.getTotal());
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResData(map);
        return res;
    }
    
}
