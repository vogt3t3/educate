package com.education.dao;

import com.education.model.StudyResourceModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 导学资源Dao层接口
 * @author 赵睿慷.
 *
 */
public interface StudyResourceModelDao {

  /**
   * 查询
   * @param courseName 传入课程名称进行模糊查询
   * @param resourceId 传入导学资源ID进行精确查询
   * @return 全部数据.
   */
  List<StudyResourceModel> getStudy(@Param("courseName")String courseName,@Param("resourceId")Integer resourceId);
}
