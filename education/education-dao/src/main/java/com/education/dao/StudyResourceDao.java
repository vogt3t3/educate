package com.education.dao;

import java.util.List;

import com.education.model.ResourceTCModel;
import com.education.model.StudyResourceModel;

/**
 * 导学资源的数据层
 * @author 申忠正
 *
 */
public interface StudyResourceDao {
    /**
     * 
     * @return List<StudyResourceModel> 导学资源 --查询所有记录到页面
     * @throws Exception 抛出数据层异常
     */
    List<ResourceTCModel> selectStudyResource(ResourceTCModel resourceTCModel)throws Exception;
    
    /**
     * @param sr 对象
     * @return int 影响的行数
     * @throws Exception
     */
    int addStudyResource(ResourceTCModel sr)throws Exception;
    /**
     * @param id
     * @return int 影响的行数
     * @throws Exception
     */
    int deleteResource(int resourceId) throws Exception;
    /**
     * 更新操作第一步 根据id查询
     * @param resourceId 传入资源id
     * @return 返回一个 资源对象
     * @throws Exception
     */
    ResourceTCModel queryResById(int resourceId) throws Exception;
    /**
     * 更新操作第二步 根据id查询
     * @param studyResourceModel 实体
     * @return int 影响的行数
     * @throws Exception
     */
    int updateResource(StudyResourceModel studyResourceModel) throws Exception;
}