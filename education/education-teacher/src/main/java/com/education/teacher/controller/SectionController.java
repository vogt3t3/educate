package com.education.teacher.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ResultDo;
import com.education.model.SecondSection;
import com.education.model.Section;
import com.education.model.SectionTree;
import com.education.model.User;
import com.education.model.VideoModel;
import com.education.service.ISectionService;
import com.education.util.PropertiesUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 章节管理的控制层
 * @author 赵京华
 *
 */
@Api(value = "/api/teacher", description = "章节管理的相关操作")
@RestController
@RequestMapping("/api/teacher")
public class SectionController {

    @Reference
    private ISectionService sections;
	/**
	 * 默认分页和按专业查询
	 * @throws Exception 
	 */

	@SuppressWarnings("unused")
	@ApiOperation(notes = "getTree", httpMethod = "POST", value = "获取所登陆的当前教师的课程章节列表")
    @RequestMapping(value="/sectionManager/getTree",method=RequestMethod.POST)
    public ResultDo<Object> say(HttpSession session) throws Exception{
		System.out.println("进入到了控制层");
		int userId=Integer.parseInt(session.getAttribute("teacherId").toString());
		String username=sections.getTeacherById(userId);
		//TODO 调用业务层获取数据
		//根据教师编号获取业务层数据
    	List<SectionTree> list=sections.listAllSection(userId);
    	System.out.println("获取得到的数据条数为："+list.size());
    	//根据教师的编号查询课程的名称
    	String kecheng = sections.getClassName(userId);
    	//TODO 将数据统一放在RestFul风格的返回值中
    	ResultDo<Object> result = new ResultDo<Object>();
    	if(result==null){
    		result.setResMsg("您还没有添加课程，请添加课程");
    	}else{
    		result.setResMsg("请求成功");
    	}
    	result.setResData(list);
    	result.setKecheng(kecheng);
    	//返回状态码
    	result.setResCode(0);
    	//System.out.println("获取了几条课程数据："+list.size());
		return result;
    }
	/**
	 * 根据session中的教师编号和页面传递过来的参数，向数据库中添加相应的课程信息
	 * @throws Exception 
	 */
	@ApiOperation(notes = "addNewClass", httpMethod = "POST", value = "教师添加章节")
    @RequestMapping(value="/sectionManager/addNewClass",method=RequestMethod.POST)
	public ResultDo<Object> addNewClass(@RequestBody Map<String, Object> map,HttpSession session) throws Exception{
		int userId=Integer.parseInt(session.getAttribute("teacherId").toString());
		String username=sections.getTeacherById(userId);

		//课程的编号（根据教师的编号查询）	
		int classId=sections.getClassId(userId);
		//课程的添加时间
		Date addDate=new Date();
		//新建要向数据库中添加的章节的对象		
		Section section =new Section();
		//课程的编号
		section.setCourse_id(classId);
		//课程添加的时间
		section.setSectionAddTime(addDate);
		//教师的id编号
		section.setTeacherId(userId);
		//修改日期
		section.setSectionModifyDate(addDate);
		//修改人
		section.setSeModifyPerson(username);
		//获取用户需要向哪个章节编号中添加
		int sectionId=Integer.parseInt(map.get("section").toString());
		//获取用户添加的章节的名称
		String newsectionname=map.get("knot").toString();
		section.setSectionName(newsectionname);
		//设置课程id
		section.setSectionId(null);
		
		//以上是添加大的章节，以下是添加章节中小的节点
		//穿件小的节点的节点对象
		SecondSection secondSection=new SecondSection();
		secondSection.setSection_id(sectionId);
		secondSection.setPart_frequence(0);
		secondSection.setPart_addtime(addDate);
		secondSection.setPart_id_name("不必填写");
		secondSection.setPart_modify_date(addDate);
		secondSection.setPart_modify_person(username);
		secondSection.setPart_name(newsectionname);
		ResultDo<Object> result = new ResultDo<Object>();
		if(sectionId==0){
			//向大的章节数据库中添加数据
			int secId=sections.addOneSection(section);
			if(secId==0){
				result.setResMsg("增加失败");
				return result;
			}
			result.setResMsg("增加成功");
			return result;
		}else{
			//否则就是向大章节中添加小节
			int afectNum=sections.addOneSmallSection(secondSection);
			if(afectNum==0){
				result.setResMsg("增加失败");
				return result;
			}
			result.setResMsg("增加成功");
			return result;
		}
	}
	
	/**
	 * 根据session中的教师编号和页面中传递过来的信息修改数据库中的课程信息
	 * 参数中的map集合是前台传递过来的参数
	 * @throws Exception 
	 */
	@ApiOperation(notes = "modifyOneClass", httpMethod = "POST", value = "教师修改章节")
    @RequestMapping(value="/sectionManager/modifyOneClass",method=RequestMethod.POST)
	public ResultDo<Object> modifyOneClass(@RequestBody Map<String, Object> map,HttpSession session) throws Exception{
		int userId=Integer.parseInt(session.getAttribute("teacherId").toString());
		String username=sections.getTeacherById(userId);

		//获取前台传递过来的章节信息
		//获取前台传递过来的需要修改的章节编号
		String sectionId=map.get("section").toString();
		String a1=sectionId.replace("[", "");
		String a2=a1.replace("]", "");
		String[] sectionIdArray=a2.split(",");
		List<Integer> sectionIdList=new ArrayList<Integer>();
		for(int i=0;i<sectionIdArray.length;i++){
			sectionIdList.add(Integer.parseInt(sectionIdArray[i].toString().trim()));
		}
		Date modifyDate=new Date();
		//获取前台传递过来的需要修改成为的信息
		String newClassName=map.get("newclassname").toString();
		//创建一个用于返回提示内容的对象
		ResultDo<Object> result = new ResultDo<Object>();
		if(sectionIdList.size()==1){
			//修改大的章节的内容
			Section section=new Section();
			//传入章节的id编号
			section.setSectionId(sectionIdList.get(0));
			//闯入修改日期
			section.setSectionModifyDate(modifyDate);
			//闯入新修改的内容
			section.setSectionName(newClassName);
			//传入修改人，从session中获取
			section.setSeModifyPerson("zhangsan");
			int modifyNum=sections.modifyOneSection(section);
			if(modifyNum!=1){
				result.setResMsg("没有修改成功，请重试");
				return result;
			}else{
				result.setResMsg("修改成功");
				return result;
			}
		}else{
			//修改小的章节的内容
			//查询出小节的编号
			int secondSectionId=sectionIdList.get(1);
			//查询出小节的访问次数
			int sequence=sections.getOneSequence(secondSectionId);
			
			//穿件对象向数据库中传递参数
			SecondSection secondSection=new SecondSection();
			secondSection.setPart_name(newClassName);
			secondSection.setPart_frequence(sequence+1);
			secondSection.setPart_modify_date(modifyDate);
			secondSection.setPart_modify_person(username);
			secondSection.setPart_id(secondSectionId);
			int modifyNum=sections.modifyOneSecondSection(secondSection);
			if(modifyNum!=1){
				result.setResMsg("没有修改成功，请重试");
				return result;
			}else{
				result.setResMsg("修改成功");
				return result;
			}
		}
	}
	
	
	/**
	 * 根据页面中传递过来的id号删除课程信息
	 * 参数中的map集合是前台传递过来的需要删除的参数
	 * @throws Exception 
	 */
	@ApiOperation(notes = "deleteOneSection", httpMethod = "POST", value = "教师删除章节")
    @RequestMapping(value="/sectionManager/deleteOneSection",method=RequestMethod.POST)
	public ResultDo<Object> deleteOneSection(@RequestBody Map<String, Object> map,HttpSession session) throws Exception{
		//TODO获取到用户的
		int userId=Integer.parseInt(session.getAttribute("teacherId").toString());
		String username=sections.getTeacherById(userId);
		//String username=user.getUserName();

		//获取从前端页面查询出来的需要删除的章节id号
		String sectionId=map.get("section").toString();
		String a1=sectionId.replace("[", "");
		String a2=a1.replace("]", "");
		String[] sectionIdArray=a2.split(",");
		List<Integer> sectionIdList=new ArrayList<Integer>();
		for(int i=0;i<sectionIdArray.length;i++){
			sectionIdList.add(Integer.parseInt(sectionIdArray[i].toString().trim()));
		}
		Date deleteDate=new Date();
		//用于向前台传递返回的信息
		ResultDo<Object> result = new ResultDo<Object>();
		if(sectionIdList.size()==1){
			Section section=new Section();
			section.setSectionId(sectionIdList.get(0));
			System.out.println("章节的编号："+sectionIdList.get(0));
			section.setSectionModifyDate(deleteDate);
			section.setSeModifyPerson("zhangsan");
			int deleteNum=sections.deleteOneSection(section);
			if(deleteNum!=0){
				result.setResMsg("删除成功");
				return result;
			}else{
				result.setResMsg("没有删除成功");
				return result;
			}
		}else{
			SecondSection secondSection=new SecondSection();
			secondSection.setPart_id(sectionIdList.get(1));
			secondSection.setPart_modify_date(deleteDate);
			secondSection.setPart_modify_person("zhangsan");
			int deleteNum=sections.deleteOneSecondSection(secondSection);
			if(deleteNum!=0){
				result.setResMsg("删除成功");
				return result;
			}else{
				result.setResMsg("没有删除成功");
				return result;
			}
		}
	}
	/**
	 * 根据页面中传递过来的小节的id号添加视频
	 * file视频的数据流
	 * session登录人的信息
	 * @throws Exception 
	 */
	@ApiOperation(notes = "videoUpLoadvideoUpLoad", httpMethod = "POST", value = "教师视频上传")
    @RequestMapping(value="/sectionManager/videoUpLoad",method=RequestMethod.POST)
	public ResultDo<Object> videoUpLoad(@RequestParam(value="sectionId") Object sectionId,@RequestParam(value="file") MultipartFile file,HttpSession session) throws Exception{
		int userId=Integer.parseInt(session.getAttribute("teacherId").toString());
		String username=sections.getTeacherById(userId);
		//视频存放的路径
		String vedioName=file.getOriginalFilename();
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(PropertiesUtil.doc+File.separator+vedioName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获取用户的用户名等
		/*User user=(User) session.getAttribute("user");
		String userName=user.getUserName();*/
		//获取添加日期
		Date addDate=new Date();
		//取出小节的小节编号
		String[] sectionsId=sectionId.toString().split(",");
		//新建视频对象
		VideoModel videoModel =new VideoModel();
		videoModel.setAddTime(addDate);
		videoModel.setPartId(Integer.parseInt(sectionsId[1].trim()));
		videoModel.setVideoAddUser(username);
		videoModel.setVideoName(vedioName);
		videoModel.setVideoPath("video"+File.separator+vedioName);
		//向对象中传递信息
		SecondSection secondSection=new SecondSection();
		secondSection.setPart_id(Integer.parseInt(sectionsId[1].trim()));
		secondSection.setPart_modify_date(addDate);
		secondSection.setPart_modify_person(username);
		//调用接口,添加数据
		try {
			sections.addOneVideo(secondSection, videoModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*System.out.println("sectionId的值为："+sectionId);
		System.out.println("aa参数为："+file.getName());
		System.out.println("视频的名称为："+vedioName);
		System.out.println("存放视频的路径为："+path);
		System.out.println("已经访问到了视频存放层"+file);*/
		return null;
	}
	/**
	 * 根据session中的教师编号查找当前教师课程的章节列表
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	@ApiOperation(notes = "getTreeListOfNoVideo", httpMethod = "POST", value = "获取没有视频的课程章节列表")
    @RequestMapping(value="/sectionManager/getTreeListOfNoVideo",method=RequestMethod.POST)
	public ResultDo<Object> getTreeListOfNoVideo(HttpSession session) throws Exception{
		int userId=Integer.parseInt(session.getAttribute("teacherId").toString());
		String username=sections.getTeacherById(userId);
		
		//根据教师编号获取业务层数据
		System.out.println("进入到了控制层");
		List<SectionTree> list=sections.listSectionOfNoVedio(userId);
		System.out.println("获取得到的数据条数为："+list.size());
		//TODO 将数据统一放在RestFul风格的返回值中
		ResultDo<Object> result = new ResultDo<Object>();
		if(result==null){
		   result.setResMsg("您还没有添加课程，请添加课程");
		}else{
		   result.setResMsg("请求成功");
		}
		result.setResData(list);
		//返回状态码
		result.setResCode(0);
		//System.out.println("获取了几条课程数据："+list.size());
		return result;
	}
}



























