package com.education.service;
import java.util.Map;
import com.education.model.ResultDo;
import com.education.model.StudentEnterModel;
/**
 * 该模块是报名模块
 * 
 * @author 申忠正
 */
public interface IEnterService {

    /**
     * 报名
     * 
     * @param student
     * @return
     */
    int addstu(StudentEnterModel student);

    /**
     * 获得store题目列表 申忠正
     * ----------------------------------------------------------------------------------
     * 
     * @param store
     *            题库编号
     * @return List<SelectModel> store题目列表
     */
    @SuppressWarnings("rawtypes")
    ResultDo<Object> getTopicList(int enter_test_type) throws Exception;

    /**
     * @param map
     *            成绩 课程id 学生id
     * @return
     * @throws Exception
     */
    int saveScore(Map map) throws Exception;

    /**
     * 报名
     * 
     * @param idcard
     * @return
     */
    int cxidcard(long idcard);
    
    
    /**
     * 默认加载对象
     */
    StudentEnterModel quertstusss(int enterId) throws Exception;
    
    /**
     * @param 把一个对象加入 学生表
     */
    int quertstu(String username, String enterIdcard, double enterPayMoney, String enterPayWay1) throws Exception;

    


}
