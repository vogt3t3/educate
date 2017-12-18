package com.education.dao;

import com.education.model.MajorModel;
import java.util.List;

import org.apache.ibatis.annotations.Param;


/**数据层
 * @author Administrator.
 *
 */
public interface MajorDao {

  /**
   * 查询
   * 传入分页数据
   * @return Major对像（集合）.
   */
  List<MajorModel> selectMajorByMajorid(@Param("majorName")String majorName,@Param("majorId")Integer majorId);
  
  
  /**
   * 修改
   * @param majorModel 传入对象
   * @return int .
   */
  int updateMajorByMajorid(MajorModel majorModel);
  
  /**
   * 增加
   * @return int.
   */
  int addMajorByMajorid(MajorModel majorModel);
    
  /**
   * 删除
   *@return int.
   */
  int deleteMajorById(int majorId);
  
}
