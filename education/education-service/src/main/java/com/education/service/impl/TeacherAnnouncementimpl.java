package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.education.dao.MteacherDao;
import com.education.model.NoticeModel;
import com.education.model.ResultDo;
import com.education.service.ITeacherAnnouncement;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * @author 张露林普通教师主页公告服务层接口的实现
 *
 */
public class TeacherAnnouncementimpl implements ITeacherAnnouncement {
	/**
     * 注入审核人员的数据层接口 CpersonDao
     */
	 @Autowired
	 private MteacherDao mteacher;
	 /**
	* 查询出要显示的所有公告要用分页
	*@param currentPage 当前页
	*@param pageSize 总数据条数
	*@return ResultDo<PageInfo<NoticeModel>> 分页实体 
	*@throws Exception 业务处理层异常
	*/
	@Override
	public ResultDo<PageInfo<NoticeModel>> selectAnnouncement(int pageNum, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
        List<NoticeModel> list = this.mteacher.queryAdvertising();
        PageInfo<NoticeModel> PageBean = new PageInfo<NoticeModel>(list);
        ResultDo<PageInfo<NoticeModel>> results = new ResultDo<PageInfo<NoticeModel>>();
        results.setResData(PageBean);
		return results;
	}
	/**
	 * 审核人员根据id查询出要显示的公告详细信息
     *@return ResultDo<<NoticeModel>> 
     *@throws Exception 业务处理层异常
     */
	@Override
	public ResultDo<NoticeModel> selectAnnouncementDetail(int noticeId) throws Exception {
		// TODO Auto-generated method stub
		NoticeModel  student= mteacher.queryAdvertisingDetails(noticeId);
		ResultDo<NoticeModel> ress = new ResultDo<NoticeModel>();
		ress.setResData(student);
		return ress;
	}

}
