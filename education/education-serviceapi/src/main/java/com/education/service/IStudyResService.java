package com.education.service;
import com.education.model.ResourceTCModel;
import com.education.model.StudyResourceModel;
import com.github.pagehelper.PageInfo;

/**
 * 导学资源服务层接口
 * @author 申忠正
 *
 */
public interface IStudyResService {
    /**
     *@param pageNo 当前页
     *@param pageSize 总数据条数
     *@return PageInfo<StudyResourceModel> 分页实体 【里面存放的是导学资源List】
     *@throws Exception 业务处理层异常
     */
    PageInfo<ResourceTCModel> selectStudyResource(ResourceTCModel resourceTCModel,Integer pageNo, Integer pageSize)throws Exception;
    
    /**
     * @param sr 对象
     * @return int add影响的行数
     * @throws Exception
     */
    int addStudyResource(ResourceTCModel sr) throws Exception;
    
    /**
     * @param resource_id
     * @return int del影响的行数
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
     * 更新操作第二步
     * @param studyResourceModel 实体
     * @return int update影响的行数
     * @throws Exception
     */
    int updateResource(StudyResourceModel studyResourceModel) throws Exception;
}
