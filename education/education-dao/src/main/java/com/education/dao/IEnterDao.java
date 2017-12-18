package com.education.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.education.model.SelectModel;
import com.education.model.StudentEnterModel;
/**
 * 该模块是报名模块
 * @author 申忠正
 */
public interface IEnterDao {
	/**
	 * 报名
	 * @param student
	 * @return
	 */
	int addstu(StudentEnterModel student);

	
	 /**查询题库storeId选择题数量       ----------------------------------------------------------------------------------
     * @param enter_test_type      类型   高 专 本 1 2
     * @return 
     */
    List<SelectModel> countSelect2(@Param("enter_test_type")int enter_test_type);
    
    
    /**
     * @param map 成绩  课程id 学生id
     * @return
     * @throws Exception
     */
    int saveScore2(Map map)throws Exception; 
	/**
	 * @param idcard 传入身份证
	 * @return 返回是否成功
	 */
     List<IEnterDao> idcard(long idcard);
     
     /**
      * @param 张建磊缴费之后，把报名表的数据录入学生表
      * @return 返回是否成功
      */
     int updateStuEnterModelaaa(@Param("enterIdcard") String enterIdcard,@Param("enterPayMoney") double enterPayMoney,@Param("enterPayWay") int enterPayWay);
     /**
      * @param 张建磊默认加载
      * @return 返回是否成功
      */
     StudentEnterModel selectStuEnterModel(Integer enterId);
     /**
      * @param 张建磊缴费其中的一部分
      * @return 返回是否成功
      */
     StudentEnterModel selectStuEnterModelaaa(String enterIdcard);

}
