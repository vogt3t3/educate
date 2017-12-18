package com.education.service;

import com.education.model.Courseware;
import com.education.model.CoursewareResId;
import com.github.pagehelper.PageInfo;

/**
 * 课件资源服务层接口
 * @author 申忠正
 *
 */
public interface ICoursewareService {
    /**
     *@param pageNo 当前页
     *@param pageSize 总数据条数
     *@return PageInfo<StudyResourceModel> 分页实体 【根据资源id查询所对应的课件】(如果资源id为空，则查询所有课件资源)
     *@throws Exception 业务处理层异常
     */
    PageInfo<Courseware> queryCourseware(int resourceId,Integer pageNo, Integer pageSize)throws Exception;
    /**
     *@param  coursewareId 课件id
     *@return 影响的行数
     *@throws Exception 业务处理层异常
     */
    int deleteCourseware(int coursewareId)throws Exception;
    /**
     * @param courseware  传入课件对象
     * @return 影响的行数 =1成功
     */
    int coursewareAdd(CoursewareResId courseware);
}
