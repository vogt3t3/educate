package com.education.service;
import com.education.model.StudentQuizModel;
import com.github.pagehelper.PageInfo;
/**
 * 赵超
 * @author 视频提问接口
 *
 */
public interface MvideoQuizService{
	/**
	 * @param pageNo 输入当前页
	 * @param pageSiz 输入一页的数据
	 * @return 分页集合
	 * @throws Exception 抛出异常
	 */
	PageInfo<StudentQuizModel>  mvpage(Integer pageNo, Integer pageSiz)throws Exception;
	
	/**
	 * @param tr 模糊查询提交内容
	 * @param pageNo 开始页面
	 * @param pageSiz 一页有几天数据
	 * @return 返回信息的集合
	 * @throws Exception 抛出异常
	 */
	PageInfo<StudentQuizModel>  mhone(String tr,Integer lx,Integer pageNo, Integer pageSiz)throws Exception;
    /**
     * @param teid   返回教师ID
     * @param reid   返回回复Id
     * @param quid   返回疑问ID
     * @param reco   返回回复
     * @throws Exception  向上抛出异常
     */
    void  updateVideoQuiz(Integer teid,Integer reid,Integer quid,String reco)throws Exception;
    /**
     * @param qid 传入的数据表的ID
     * @return 返回是否成功
     * @throws Exception 向上抛出异常
     */
    int  delevoide(Integer qid)throws Exception;

  
}
