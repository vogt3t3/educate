/**
 * 
 */
package com.education.service;
import com.education.model.ThesisLayoutModel;
import com.education.model.ThesisModel;
import com.github.pagehelper.PageInfo;

/**
 * 学生端论文服务层接口
 * 
 * @author 周长磊
 *
 */
public interface IStuthesisService {

    /**
     * 获取论文规范
     * 
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return PageInfo<ThesisLayoutModel> 分页实体
     * @throws Exception
     *             抛出异常
     */
    PageInfo<ThesisLayoutModel> listThesisLayout(Integer pageNo, Integer pageSize) throws Exception;

    /**
     * 获取论文
     * 
     * @param studentId
     *            学生编号
     * @param pageNo
     *            当前页
     * @param pageSize
     *            总数据条数
     * @return PageInfo<ThesisLayoutModel> 分页实体
     * @throws Exception
     *             抛出异常
     */
    PageInfo<ThesisModel> listThesis(Integer studentId, Integer pageNo, Integer pageSize) throws Exception;

    /**
     * 提交论文
     * 
     * @param th
     *            论文实体
     * @return int 
     * @throws Exception
     *             抛出异常
     */
    int saveThesis(ThesisModel th) throws Exception;

}
