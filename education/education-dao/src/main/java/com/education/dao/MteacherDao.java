package com.education.dao;

import java.util.List;

import com.education.model.NoticeModel;


/**
 * @author 张露林普通教师主页的dao层
 *
 */

public interface MteacherDao {
	
	//查询出要显示的所有公告要用分页
	List<NoticeModel> queryAdvertising();
	//审核人员根据id查询出要显示的公告详细信息
	NoticeModel queryAdvertisingDetails(int noticeId);
}
