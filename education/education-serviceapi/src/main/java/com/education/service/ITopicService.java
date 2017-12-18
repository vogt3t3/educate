package com.education.service;

import java.util.List;
import java.util.Map;
import com.education.model.ResultDo;
/**试题服务接口
 * @author 赵润
 * @param <T>
 *
 */
public interface ITopicService<T> {

    /**获得store题目列表
     * @param store 题库编号
     * @return List<SelectModel> store题目列表
     */
    @SuppressWarnings("rawtypes")
    ResultDo<Map<String,List>> getTopicList(int storeId) throws Exception;
}
