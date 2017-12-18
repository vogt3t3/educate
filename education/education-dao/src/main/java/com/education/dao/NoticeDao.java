package com.education.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.education.model.NoticeModel;
import com.education.model.NoticeModelDate;

/**
 * 公告管理接口
 * 
 * @author 张建磊
 *
 */
public interface NoticeDao {

    /**
     * 添加公告
     * 
     * @param notice
     *            实体类别名
     * @return int
     * @throws Exception
     *             异常抛出
     */
    int sessionNoticeModel(@Param("notice") NoticeModel notice) throws Exception;
    
    /**
     * 查询公告
     * @param noticeId 公告id
     * @return NoticeModel getNotice
     * @throws Exception
     *              异常抛出
     */
    NoticeModel getNotice(@Param("noticeId") Integer noticeId) throws Exception;
   
    /**
     * 遍历公告（分页查询 + 模糊查询（根据公告标题,公告时间））
     * @param notice 公告日期实体类别名
     * @return List<NoticeModel>
     * @throws Exception
     *               异常抛出
     */
    List<NoticeModelDate> listNoticeByName(@Param("notice") NoticeModelDate notice)throws Exception;
    
    /**
     * @return 公告集合
     */
    List<NoticeModel> querynoticeList();
    
}
