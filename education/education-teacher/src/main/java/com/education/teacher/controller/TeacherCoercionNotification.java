package com.education.teacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.NoticeModel;
import com.education.model.ResultDo;
import com.education.service.ITeacherAnnouncement;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * @author 张露林教师主页的控制层
 */
@Api(value = "/api/teacher", description = "报名审核")
@Controller
@RequestMapping("/api/teacher")
public class TeacherCoercionNotification {
	
	@Reference
	private ITeacherAnnouncement announcement;
	/**
	 * @return String
	 * @author 教师主页的显示
	 */
	@ApiOperation(notes = "/master/index", httpMethod = "GET", value = "教师主页的显示")
    @RequestMapping("/master/index")
	@ResponseBody
    public ResultDo<PageInfo<NoticeModel>> selectAnnoun(Integer currentPage, Integer pageSize) throws Exception{
    	//获取从前台传来的数据
		ResultDo<PageInfo<NoticeModel>> res = announcement.selectAnnouncement(currentPage, pageSize);
    	return res;
    }
	/**
	 * @return String
	 * @author 教师主页的显示详情(根据id)
	 */
	@ApiOperation(notes = "/master/indexAnnouncement", httpMethod = "GET", value = "教师主页的显示详情(根据id)")
    @RequestMapping("/master/indexAnnouncement")
	@ResponseBody
	public ResultDo<NoticeModel> selectAnnounDetail(int noticeId) throws Exception{
		ResultDo<NoticeModel> res = announcement.selectAnnouncementDetail(noticeId);
		return res;
	}
}
