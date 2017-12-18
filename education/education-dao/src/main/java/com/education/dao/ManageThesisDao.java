package com.education.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.education.model.ThesisDo;

/**
 * 论文管理
 * @author 刘帅
 *
 */
public interface ManageThesisDao {
    
    /**
     * 获得所有论文
     * @return
     */
    List<ThesisDo> getThesis();

    /**
     * 根据论文编号，添加成绩
     * @param thesisScore 论文成绩
     * @param thesisId 编号
     * @return 影响行数
     */
    int addScore(@Param("thesisScore")int thesisScore,@Param("thesisId")int thesisId);
}
