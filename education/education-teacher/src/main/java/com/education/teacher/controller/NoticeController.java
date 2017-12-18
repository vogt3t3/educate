package com.education.teacher.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.NoticeModel;
import com.education.model.NoticeModelDate;
import com.education.model.ResultDo;
import com.education.service.INoticeService;
import com.github.pagehelper.PageInfo;

/**
 * 公告管理控制层
 * 
 * @author 张建磊
 *
 */
@Controller
@RequestMapping("/api/admin")
public class NoticeController {

    /**
     * @Reference 新建接口对象 控制层自动注入
     */
    @Reference
    private INoticeService inoticeService;

    /**
     * 日志记录类
     */
    private static Logger LOGGER = LogManager.getLogger(NoticeController.class);

    /**
     * 添加公告
     * 
     * @param nModel
     *            实体类别名
     * @param session
     *            session对象
     * @return ResultDo<Object>
     * @throws Exception
     *             异常抛出
     */
    @RequestMapping(value = "/addnotice", method = RequestMethod.POST)
    @ResponseBody
    public ResultDo<Object> add(@RequestBody NoticeModel nModel, HttpSession session) throws Exception {

        session.setAttribute("teacherRealName", "张老师");

        // nModel.setNoticeCreateDate(new Date());
        nModel.setNoticeModifyDate(new Date());
        nModel.setNoticeModifyName((String) session.getAttribute("teacherRealName"));
        nModel.setNoticeDel(1);

        int records = inoticeService.sessionNoticeModel(nModel);
        ResultDo<Object> res = new ResultDo<Object>();
        if (records > 0) {
            res.setResData(records);
            res.setResCode(0);
            res.setResMsg("添加成功");
        } else {
            res.setResCode(-1);
            res.setResMsg("添加失败");
        }
        return res;
    }

    /**
     * 根据ID查询公告
     * 
     * @param noticeId
     *            公告id
     * @return ResultDo<NoticeModel>
     * @throws Exception
     *             异常抛出
     */
    @RequestMapping("/querynotice")
    @ResponseBody
    public ResultDo<Object> getNotice(@RequestParam("noticeId") Integer noticeId) throws Exception {
        LOGGER.info("公告ID" + noticeId);
        NoticeModel noticeModel = inoticeService.getNotice(noticeId);
        
        ResultDo<Object> res = new ResultDo<Object>();
        if(noticeModel != null) {
            res.setResCode(0);
            res.setResMsg("请求成功");
            res.setResData(noticeModel);
        } else {
            res.setResCode(-1);
            res.setResMsg("请求失败");
        }
        LOGGER.info(res);
        return res;
    }

    /**
     * 遍历公告内容（分页查询 + 模糊查询（公告标题，公告时间））
     * 
     * @param pageNo
     *            分页数
     * @param pageSize
     *            分页总数
     * @param notice
     *            实体类别名
     * @return ResultDo<PageInfo<NoticeModel>>
     * @throws Exception
     *             异常抛出
     */
    @RequestMapping("/querylikenotice")
    @ResponseBody
    public ResultDo<Object> listNoticeByPage(NoticeModelDate notice, Integer pageNo, Integer pageSize)
            throws Exception {
        System.out.println(notice.getStartDate() + "\t" + notice.getEndDate());
        // 返回查询结果
        PageInfo<NoticeModelDate> data = inoticeService.listNoticeByPage(notice, pageNo, pageSize);

        // 将查询结果传给PageInfo对象
        ResultDo<Object> rs = new ResultDo<Object>();
        if (data.getList() != null) {
            rs.setResCode(0);
            rs.setResMsg("请求成功");
            rs.setResData(data);
        } else {
            rs.setResCode(-1);
            rs.setResMsg("请求失败");
        }
        LOGGER.info(rs);
        return rs;
    }

    /**
     * 公告集合查询
     * 
     * @param Object
     * @return ResultDo<Object>
     * @throws Exception
     *             异常抛出
     */
    @RequestMapping("/querynoticeList")
    @ResponseBody
    public ResultDo<Object> querynoticeList() throws Exception {
        List<NoticeModel> noticeList = inoticeService.querynoticeList();

        ResultDo<Object> res = new ResultDo<Object>();
        if(noticeList.size() > 0) {
            res.setResCode(0);
            res.setResMsg("请求成功");
            res.setResData(noticeList);
        } else {
            res.setResCode(-1);
            res.setResMsg("请求失败");
        }
        LOGGER.info(res);
        return res;
    }
}
