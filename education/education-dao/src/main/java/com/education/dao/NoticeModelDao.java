package com.education.dao;

import com.education.model.NoticeModel;
import java.util.List;

/**
 * 公告详情Dao层接口
 * @author 赵睿慷.
 *
 */
public interface NoticeModelDao {

  /**
   * 查询
   * @return 通过全部信息.
   */
  List<NoticeModel> selectNoticeById();
  
}
