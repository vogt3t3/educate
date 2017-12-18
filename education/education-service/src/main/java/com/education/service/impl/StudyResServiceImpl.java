package com.education.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.StudyResourceDao;
import com.education.model.ResourceTCModel;
import com.education.model.StudyResourceModel;
import com.education.service.IStudyResService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 导学资源服务层服务
 * @author 申忠正
 *
 */
@Service
public class StudyResServiceImpl implements IStudyResService{
    /**
     * 注入导学资源的数据层接口 StudyResourceDao
     */
    @Autowired 
    private StudyResourceDao studyResourceDao;
    
    /**
     *@param pageNo 当前页
     *@param pageSize 总数据条数
     *@return PageInfo<StudyResourceModel> 分页实体 【里面存放的是导学资源List】
     *@throws Exception 业务处理层异常
     */
    public PageInfo<ResourceTCModel> selectStudyResource(ResourceTCModel resourceTCModel,Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        //查询结果返回
        List<ResourceTCModel> list = studyResourceDao.selectStudyResource(resourceTCModel);
        //将查询结果传给PageInfo对象
        PageInfo<ResourceTCModel> page = new PageInfo<ResourceTCModel>(list);      
        return page;
    }
    /**
     *@param 传入对象
     *@return int add影响的行数
     *@throws Exception 业务处理层异常
     */
    public int addStudyResource(ResourceTCModel sr) throws Exception {
        int result = studyResourceDao.addStudyResource(sr);
        return result;
    }
    /**
     *@param 传入id
     *@return int del影响的行数
     *@throws Exception 业务处理层异常
     */
    public int deleteResource(int resourceId) throws Exception {
        int result = studyResourceDao.deleteResource(resourceId);
        return result;
    }
    /**
     * 更新操作第一步 根据id查询
     * @param resourceId 传入资源id
     * @return 返回一个 资源对象
     * @throws Exception
     */
    public ResourceTCModel queryResById(int resourceId) throws Exception {
        ResourceTCModel resourceTCModel = studyResourceDao.queryResById(resourceId);
        return resourceTCModel;
    }
    /**
     * 更新操作第二步 根据id查询
     * @param studyResourceModel 实体
     * @return int update影响的行数
     * @throws Exception
     */
    public int updateResource(StudyResourceModel studyResourceModel) throws Exception {
        int result = studyResourceDao.updateResource(studyResourceModel);
        return result;
    }
    

}
