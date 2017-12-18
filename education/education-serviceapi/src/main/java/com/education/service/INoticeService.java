package com.education.service;
import java.util.List;
import com.education.model.NoticeModel;
import com.education.model.NoticeModelDate;
import com.github.pagehelper.PageInfo;

/**
 * 公告管理服务层接口
 * 
 * @author 张建磊
 *
 */
public interface INoticeService {

    /**
     * 添加公告服务层接口
     * 
     * @param notice
     *            公告管理实体类
     * @return int
     * @throws Exception
     *             异常抛出
     */
    int sessionNoticeModel(NoticeModel notice) throws Exception;

    /**
     * 根据公告id查询公告
     * 
     * @param noticeId
     *            公告id
     * @return NoticeModel getNotice
     * @throws Exception
     *             异常抛出
     */
    NoticeModel getNotice(Integer noticeId) throws Exception;

    /**
     * 遍历公告内容（分页查询 + 模糊查询（公告标题））
     * 
     * @param notice
     *            日期实体类别名
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return PageInfo <NoticeModel>
     * @throws Exception
     *             异常抛出
     */
    PageInfo<NoticeModelDate> listNoticeByPage(NoticeModelDate notice, Integer pageNo, Integer pageSize)
            throws Exception;
    
    /**
     * @return 公告集合
     */
    List<NoticeModel> querynoticeList();

}
