/**
 * 
 */
package com.education.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.education.dao.StuthesisDao;
import com.education.model.ThesisLayoutModel;
import com.education.model.ThesisModel;
import com.education.service.IStuthesisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 学生端论文服务层实现类
 * 
 * @author 周长磊
 *
 */
public class StuthesisServiceImpl implements IStuthesisService {

    /**
     * 学生端论文接口
     */
    @Autowired
    private StuthesisDao stuthesisDao;

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
    public PageInfo<ThesisLayoutModel> listThesisLayout(Integer pageNo, Integer pageSize) throws Exception {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        // 开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);

        // 返回查询结果
        List<ThesisLayoutModel> list = stuthesisDao.listThesisLayout();

        // 将查询结果传给PageInfo对象
        PageInfo<ThesisLayoutModel> pageInfo = new PageInfo<ThesisLayoutModel>(list);
        return pageInfo;
    }

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
    public PageInfo<ThesisModel> listThesis(Integer studentId, Integer pageNo, Integer pageSize) throws Exception {

        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        // 开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);

        // 返回查询结果
        List<ThesisModel> list = stuthesisDao.listThesis(studentId);

        // 将查询结果传给PageInfo对象
        PageInfo<ThesisModel> pageInfo = new PageInfo<ThesisModel>(list);
        return pageInfo;
    }

    /**
     * 提交论文
     * 
     * @param th
     *            论文实体
     * @return int
     * @throws Exception
     */
    public int saveThesis(ThesisModel th) throws Exception {

        int record = stuthesisDao.saveThesis(th);
        return record;
    }

}
