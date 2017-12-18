package com.education.dao;

import java.util.List;

import com.education.model.SecondSection;
import com.education.model.Section;
import com.education.model.SectionTree;
import com.education.model.VideoModel;

/**
 * 章节管理数据层
 * @author 赵京华
 *
 */
public interface SectionPartDao {
    /**
     * @param teacherId 教师编号
     * @return List<SectionPartModel> 返回章节和小结信息
     * @throws Exception 抛出业务层异常
     */
    List<SectionTree> listAllSection(int teacherId) throws Exception;
    /**
     * @param teacherId 教师编号
     * @return String 返回教师的姓名
     * @throws Exception 抛出业务层异常
     */
    String getTeacherNameById(int teacherId) throws Exception;
    /**
     * @param teacherId 教师编号
     * @return List<SectionPartModel> 返回没有小节的章节信息
     * @throws Exception 抛出业务层异常
     */
    List<SectionTree> listSectionNoSecond(int teacherId) throws Exception;
    /**
     * @param teacherId 教师编号
     * @return List<SectionPartModel> 返回没有视频的章节
     * @throws Exception 抛出业务层异常
     */
    List<SectionTree> listSectionNoVideo(int teacherId) throws Exception;
    /**
     * @param teacherId 教师编号
     * @return 查询课程的名称
     * @throws Exception 抛出业务层异常
     */
    String queryClassName(int teacherId) throws Exception;  
    /**
     * @param teacherId 教师编号
     * @return 课程的编号
     * @throws Exception 抛出业务层异常
     */
    int queryClassId(int teacherId) throws Exception;
    /**
     * @param section 章节的具体详情
     * @return 添加的数量
     * @throws Exception 抛出业务层异常
     * 向数据库中添加大章节
     */
    int addSection(Section section) throws Exception;
    /**
     * @param secondSection 小节的具体详情
     * @return 添加的数量
     * @throws Exception 抛出业务层异常
     * 向数据库中添加小章节
     */
    int addSmallSection(SecondSection secondSection) throws Exception;
    /**
     * @param Section 大的章节中需要修改的内容
     * @return 修改的数量
     * @throws Exception 抛出业务层异常
     * 修改大的章节中的内容
     */
    int modifySection(Section section) throws Exception;
    /**
     * @param Section 小的章节中需要修改的内容
     * @return 修改的数量
     * @throws Exception 抛出业务层异常
     * 修改小的章节中的内容
     */
    int modifySecondSection(SecondSection secondSection) throws Exception;
    
    /**
     * @param part_id 小的章节的编号
     * @return 查询出来的值
     * @throws Exception 抛出业务层异常
     * 根据小节编号查询出访问的次数
     */
    int getFrequence(int part_id) throws Exception;
    /**
     * @param section 删除的大章节一些基本信息
     * @return 返回删除了几条数据
     * @throws Exception 抛出业务层异常
     */
    int deleteSection(Section section) throws Exception;
    /**
     * @param section 根据大的章节删除小章节的一些基本信息
     * @return 返回删除了几条数据
     * @throws Exception 抛出业务层异常
     */
    int deleteSecondSectionBySection(Section section) throws Exception;
    
    /**
     * @param section 单独删除小章节的一些基本信息
     * @return 返回删除了几条数据
     * @throws Exception 抛出业务层异常
     */
    int deleteSecondSection(SecondSection secondSection) throws Exception;
    /**
     * @param secondSection小节中一些关于视频的信息
     * @return 返回添加了几条视频记录
     * @throws Exception 抛出业务层异常
     */
    int addVideo(SecondSection secondSection) throws Exception;
    /**
     * @param VideoModel 视频信息
     * @return 向视频表中添加了几条数据
     * @throws Exception 抛出业务层异常
     */
    int addVideoToVideoTable(VideoModel videoModel) throws Exception;
}











