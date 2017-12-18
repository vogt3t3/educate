/**
 * 
 */
package com.education.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.education.model.ThesisLayoutModel;
import com.education.model.ThesisModel;

/**
 * 学生端论文接口
 * 
 * @author 周长磊
 *
 */
public interface StuthesisDao {

    /**
     * 获取论文规范
     * 
     * @return List<ThesisLayoutModel>
     * @throws Exception
     *             抛出异常
     */
    List<ThesisLayoutModel> listThesisLayout() throws Exception;

    /**
     * 获取论文
     * 
     * @param studentId
     *            学生编号
     * @return List<ThesisModel>
     * @throws Exception
     *             抛出异常
     */
    List<ThesisModel> listThesis(@Param("studentId") Integer studentId) throws Exception;
    
    /**
     * 提交论文
     * 
     * @param th
     *            论文实体
     * @return int
     * @throws Exception
     *             抛出异常
     */
    int saveThesis(@Param("th") ThesisModel th) throws Exception;
}
