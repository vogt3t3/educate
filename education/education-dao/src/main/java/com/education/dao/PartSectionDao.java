package com.education.dao;

import java.util.List;

import com.education.model.PartSectionModel;

/**
 * 小节
 * @author 刘帅
 *
 */
public interface PartSectionDao {
    
    /**
     * 查询所有小节
     * @param sectionId 章节编号
     * @return
     */
    List<PartSectionModel> queryPart(int sectionId);
}
