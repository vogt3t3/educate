package com.education.service;

import java.util.List;

import com.education.model.SecondSection;
import com.education.model.Section;
import com.education.model.SectionTree;
import com.education.model.VideoModel;

/**
 * 章节管理数据层接口
 * @author 赵京华
 *
 */
public interface ISectionService {
    /**
     * 根据教师编号查找当前教师所教课程的章节信息
     * @param teacherId 教师编号
     * @return List<SectionTree> tree类型
     * @throws Exception 抛出底层异常
     */
    List<SectionTree> listAllSection(int teacherId) throws Exception;
    /**
     * 根据教师编号查找当前教师的真实姓名
     * @param teacherId 教师编号
     * @return String 教师的姓名
     * @throws Exception 抛出底层异常
     */
    String getTeacherById(int teacherId) throws Exception;
    /**
     * 根据教师编号查找当前教师所教课程的章节中没有添加视频的信息
     * @param teacherId 教师编号
     * @return List<SectionTree> tree类型
     * @throws Exception 抛出底层异常
     */
    List<SectionTree> listSectionOfNoVedio(int teacherId) throws Exception;
    /**
     * 根据教师编号查找当前教师所教的课程名称
     * @param teacherId 教师编号
     * @return String
     * @throws Exception 抛出底层异常
     */
    String getClassName(int teacherId) throws Exception;
    /**
     * 根据教师编号查找当前教师所教的课程id号
     * @param teacherId 教师编号
     * @return String
     * @throws Exception 抛出底层异常
     */
    int getClassId(int teacherId) throws Exception;
    /**
     * 向教师的课程中添加章节信息
     * @param Section添加的信息详情
     * @return int
     * @throws Exception 抛出底层异常
     */
    int addOneSection(Section section) throws Exception;
    /**
     * @param secondSection 小节的具体详情
     * @return 添加的数量
     * @throws Exception 抛出业务层异常
     * 向数据库中添加一个小章节
     */
    int addOneSmallSection(SecondSection secondSection) throws Exception;
    /**
     * @param section 要修改成为的章节信息
     * @return 修改的数量
     * @throws Exception 抛出业务层异常
     * 修改章节的信息
     */
    int modifyOneSection(Section section) throws Exception;
    /**
     * @param part_id 要修改的小节的编号
     * @return 根据编号查询到的该条记录的访问次数
     * @throws Exception 抛出业务层异常
     */
    int getOneSequence(int part_id) throws Exception;
    /**
     * @param secondSection 具体修改的内同
     * @return 根据编号修改小节中的内容
     * @throws Exception 抛出业务层异常
     */
    int modifyOneSecondSection(SecondSection secondSection) throws Exception;
    /**
     * @param section 删除的大章节一些基本信息
     * @return 返回删除了几条数据
     * @throws Exception 抛出业务层异常
     */
    int deleteOneSection(Section section) throws Exception;
    /**
     * @param section 删除的小章节一些基本信息
     * @return 返回删除了几条数据
     * @throws Exception 抛出业务层异常
     */
    int deleteOneSecondSection(SecondSection secondSection) throws Exception;
    /**
     * @param videoPath 视频的存储路径
     * @return 返回添加了几条视频记录
     * @throws Exception 抛出业务层异常
     */
    int addOneVideo(SecondSection secondSection,VideoModel videoModel) throws Exception;
}












