package com.education.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.SectionPartDao;
import com.education.model.SecondSection;
import com.education.model.Section;
import com.education.model.SectionTree;
import com.education.model.VideoModel;
import com.education.service.ISectionService;

/**
 * 查询章节信息业务层接口实现
 * @author 杨振欣
 *
 */
@Service
public class ISectionServiceImpl implements  ISectionService{

    /**
     * 注入数据层接口
     */
    @Autowired
    private SectionPartDao sectionDao;
    
    /**
     * 查询提供的教师编号下的课程的所有章节信息
     * @param teacherId 教师编号
     * @return List<SectionTree>
     * @throws Exception 抛出处理异常
     */
    @SuppressWarnings("rawtypes")
	public  List<SectionTree> listAllSection(int teacherId) throws Exception {
    	//TODO 查询出所有的章节信息,特别要注意，大的章节在未删除的情况下也必须要显示出来，所以需要将没有删除的但是没有子章节或者
    	//子章节全部被删除的也要显示出来
    	List<SectionTree> list=sectionDao.listAllSection(teacherId);
    	@SuppressWarnings("unchecked")
		List<Integer> idList=new ArrayList();
    	System.out.println(list.size());
    	List<SectionTree> listNoSecond=sectionDao.listSectionNoSecond(teacherId);
    	for(int j=0;j<list.size();j++){
			idList.add(list.get(j).getId());
		}
    	for(int i=0;i<listNoSecond.size();i++){
    		int a=listNoSecond.get(i).getId();
    		if(!idList.contains(a)){
    			list.add(listNoSecond.get(i));
    		}
    	}
        return list;
    }
    
    /**
     * 根据教师编号查找当前教师所教的课程名称
     * @param teacherId 教师编号
     * @return String类型
     * @throws Exception 抛出底层异常
     */
	public String getClassName(int teacherId) throws Exception {
		String className=sectionDao.queryClassName(teacherId);
		return className;
	}
	
	/**
     * 根据教师编号查找当前教师所教的课程名称
     * @param teacherId 教师编号
     * @return String类型
     * @throws Exception 抛出底层异常
     */
	public int getClassId(int teacherId) throws Exception {
		int classId=sectionDao.queryClassId(teacherId);
		return classId;
	}
	
	/**
     * 向教师的课程中添加章节信息
     * @param Section添加的信息详情
     * @return int
     * @throws Exception 抛出底层异常
     */
	@Override
	public int addOneSection(Section section) throws Exception {
		@SuppressWarnings("unused")
		int SectionAddNum=sectionDao.addSection(section);
		//返回章节编号
		int sectionid=section.getSectionId();
		return sectionid;
	}
	
	/**
     * @param secondSection 小节的具体详情
     * @return 添加的数量
     * @throws Exception 抛出业务层异常
     * 向数据库中添加一个小章节
     */
	@Override
	public int addOneSmallSection(SecondSection secondSection) throws Exception {
		int afectNum=sectionDao.addSmallSection(secondSection);
		return afectNum;
	}
	
	/**
     * @param section 要修改的章节的详情
     * @return 修改的数量
     * @throws Exception 抛出业务层异常
     */
	@Override
	public int modifyOneSection(Section section) throws Exception {
		int modifyNum=sectionDao.modifySection(section);
		return modifyNum;
	}
	/**
     * @param part_id 要修改的小节的编号
     * @return 根据编号查询到的该条记录的访问次数
     * @throws Exception 抛出业务层异常
     */
	@Override
	public int getOneSequence(int part_id) throws Exception {
		int sequence=sectionDao.getFrequence(part_id);
		return sequence;
	}
	/**
     * @param secondSection 具体修改的内同
     * @return 根据编号修改小节中的内容
     * @throws Exception 抛出业务层异常
     */
	@Override
	public int modifyOneSecondSection(SecondSection secondSection) throws Exception {
		int updateNum=sectionDao.modifySecondSection(secondSection);
		return updateNum;
	}
	/**
     * @param section 删除的大章节一些基本信息
     * @return 返回删除了几条数据
     * @throws Exception 抛出业务层异常
     */
	@Override
	public int deleteOneSection(Section section) throws Exception {
		int deleteNum=sectionDao.deleteSection(section);
		sectionDao.deleteSecondSectionBySection(section);
		return deleteNum;
	}
	 /**
     * @param section 单独删除小章节的一些基本信息
     * @return 返回删除了几条数据
     * @throws Exception 抛出业务层异常
     */
	@Override
	public int deleteOneSecondSection(SecondSection secondSection) throws Exception {
		int deleteNum=sectionDao.deleteSecondSection(secondSection);
		return deleteNum;
	}
	/**
     * @param videoPath 视频的存储路径
     * @return 返回添加了几条视频记录
     * @throws Exception 抛出业务层异常
     */
	@Override
	@Transactional
	public int addOneVideo(SecondSection secondSection,VideoModel videoModel) throws Exception {
		sectionDao.addVideoToVideoTable(videoModel);
		int videoId=videoModel.getVideoId();
		System.out.println("获取到的视频的编号为："+videoId);
		secondSection.setVideo_id(videoId);
		int addVideoNum=sectionDao.addVideo(secondSection);
		return addVideoNum;
	}
	/**
     * 根据教师编号查找当前教师所教课程的章节中没有添加视频的信息
     * @param teacherId 教师编号
     * @return List<SectionTree> tree类型
     * @throws Exception 抛出底层异常
     */
	@Override
	public List<SectionTree> listSectionOfNoVedio(int teacherId) throws Exception {
		List<SectionTree> list=sectionDao.listSectionNoVideo(teacherId);
		return list;
	}
	/**
     * 根据教师编号查找当前教师的真实姓名
     * @param teacherId 教师编号
     * @return String 教师的姓名
     * @throws Exception 抛出底层异常
     */
	@Override
	public String getTeacherById(int teacherId) throws Exception {
		String teacherName=sectionDao.getTeacherNameById(teacherId);
		return teacherName;
	}
	
}
