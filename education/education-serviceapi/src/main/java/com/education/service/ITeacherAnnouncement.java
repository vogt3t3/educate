package com.education.service;

import com.education.model.NoticeModel;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;

/**
 * @author 张露林普通教师主页公告服务层接口
 *
 */
public interface ITeacherAnnouncement {
	/**
	 * 查询出要显示的所有公告要用分页
     *@param currentPage 当前页
     *@param pageSize 总数据条数
     *@return ResultDo<PageInfo<NoticeModel>> 分页实体 
     *@throws Exception 业务处理层异常
     */
	ResultDo<PageInfo<NoticeModel>> selectAnnouncement(int pageNum, int pageSize) throws Exception;
	/**
	 * 审核人员根据id查询出要显示的公告详细信息
     *@return ResultDo<<NoticeModel>> 
     *@throws Exception 业务处理层异常
     */
	ResultDo<NoticeModel> selectAnnouncementDetail(int noticeId) throws Exception;
}
