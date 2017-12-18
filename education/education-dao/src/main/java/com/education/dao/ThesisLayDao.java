package com.education.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.model.ThesisLayDo;
import com.education.model.ThesisLayoutModel;

/**
 * 论文规范
 * 当添加论文规范时，把论文规范的编号添加到专业表中
 * @author 刘帅
 *
 */
public interface ThesisLayDao {

    /**
     * 获得论文规范列表
     * @return 论文规范列表
     */
    List<ThesisLayDo> getThesisLay();
    
    /**
     * 根据专业名称得到专业编号
     * @return 论文规范列表
     */
    int getThesisLayId(@Param("majorName") String majorName);
    
    /**
     * 添加论文格式
     * @param thesisLay 论文格式
     * @return
     */
    int addThesisLay(ThesisLayDo thesisLay);
    
    /**
     * 修改专业表中的论文规范编号
     * @param thesisLay 论文格式
     * @return
     */
    int updateMajor(ThesisLayDo thesisLay);
}
