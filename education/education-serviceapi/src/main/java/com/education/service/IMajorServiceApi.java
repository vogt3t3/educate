package com.education.service;

import com.education.model.MajorModel;
import com.github.pagehelper.PageInfo;

/**业务层MajorSerciceApi
 * @author 赵睿慷
 *
 */
public interface IMajorServiceApi {
	
    /**
     * 查询
     * 传入分页数据
     * @param majorName 用户名
     * @param majorId   用户ID
     * @param pageNo 当前页
     * @param pageSize 总数据条数
     * @return PageInfo<MajorName> 分页实体
     */
    PageInfo<MajorModel> selectMajorByMajorid(String majorName,Integer majorId,Integer pageNo, Integer pageSize);
    
    /**
     * 修改
     * @param majorModel 传入对象
     * @return int .
     */
    int updateMajorByMajorid(MajorModel majorModel);
    
    /**
     * 增加
     * @param majorModel 传入对象
     * @return int.
     */
    int addMajorByMajorid(MajorModel majorModel);
      
    /**
     * 删除
     * @param majorId 传入id
     * @return int.
     */
    int deleteMajorById(int majorId);
}
