package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.NoticeDao;
import com.education.model.NoticeModel;
import com.education.model.NoticeModelDate;
import com.education.service.INoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 公告管理服务层接口的实现类
 * 
 * @author 张建磊
 *
 */
@Service
public class NoticeServiceImpl implements INoticeService {

    /**
     * @Autowired 自动注入 新建接口对象noticeDao
     */
    @Autowired
    private NoticeDao noticeDao;

    /**
     * 添加公告管理
     * @param notice
     *            实体类别名
     * @return int records 实体类别名
     * @throws Exception
     *             抛出异常
     */
    @Override
    public int sessionNoticeModel(NoticeModel notice) throws Exception {
        int records = noticeDao.sessionNoticeModel(notice);
        return records;
    }

    /**
     * 根据公告ID查询公告
     * @param noticeId
     *            公告ID
     * @return intnotices 实体类别名
     * @throws Exception
     *             抛出异常
     */
    @Override
    public NoticeModel getNotice(Integer noticeId) throws Exception {
        NoticeModel notices = noticeDao.getNotice(noticeId);
        return notices;
    }

    /**
     * 根据公告标题，公告时间模糊查询公告+分页
     * @param notice 实体类别名
     * @param pageNo 当前页
     * @param pageSize 总页数
     * @return PageInfo<NoticeModel>
     * @throws Exception
     *             抛出异常
     */
    public PageInfo<NoticeModelDate> listNoticeByPage(NoticeModelDate notice, Integer pageNo, Integer pageSize)
            throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        // 开启分页 参数为当前页和数据条数

        PageHelper.startPage(pageNo, pageSize);
        // 返回查询结果
        // 1.按照公告标题模糊查询
        // 2.按照公告时间模糊查询
        List<NoticeModelDate> listNotice = noticeDao.listNoticeByName(notice);
        // 将查询结果传给PageInfo对象
        PageInfo<NoticeModelDate> pageData = new PageInfo<NoticeModelDate>(listNotice);
        return pageData;
    }

    /**
     * 公告查询
     * @return List<NoticeModel>
     * @throws Exception
     *             抛出异常
     */

    public List<NoticeModel> querynoticeList() {
        System.out.println("ser1");
        List<NoticeModel> noticeList = noticeDao.querynoticeList();
        System.out.println("ser2");
        return noticeList;
    }

}
