package com.education.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.education.dao.EnterCopyStudent;
import com.education.dao.IEnterDao;
import com.education.model.ResultDo;
import com.education.model.SelectModel;
import com.education.model.StudentEnterModel;
import com.education.service.IEnterService;
/**
 * 学生端报名实现
 * 
 * @author 申忠正
 */
@Service
public class EnterServiceImpl implements IEnterService {
    @Autowired
    private IEnterDao ieDao;
    @Autowired
    private EnterCopyStudent Copy;
    /**
     * 试题服务
     * @author 申忠正
     * @param <T>
     *
     */
    public ResultDo<Object> getTopicList(int enter_test_type) {
        // 题库中选择题 试题集合
        List<SelectModel> seleList = ieDao.countSelect2(enter_test_type);
        Set<SelectModel> selectSet = new HashSet<SelectModel>();
        Random ran = new Random();
        // 随机出选择题
        while (true) {
            int num = ran.nextInt(seleList.size());
            selectSet.add(seleList.get(num));
            System.out.println(selectSet.size());
            if (selectSet.size() == 3) {
                break;
            }
        }
        // List selectList2 = new ArrayList(selectSet);
        Map<String, Object> map = new HashMap<String, Object>();
        // map.put("selectTopics",selectList2);
        map.put("list", seleList);
        ResultDo<Object> res = new ResultDo<Object>();
        res.setResCode(0);
        res.setResMsg("success");
        res.setResData(map);
        return res;
    }
    
    /**
     * @param student
     * @return  报名注册
     */
    @Override
    public int addstu(StudentEnterModel student) {
        int result = ieDao.addstu(student);
        return result;
    }
    
    /**
     * @param 根据ID 查询 是否审核通过
     * @return
     */
    @Override
    public int cxidcard(long idcard) {
        int result1=0;
        List<IEnterDao> result = ieDao.idcard(idcard);
        if(result.size()>0){
           result1=1;
        }else{
            result1=0;
        }
        return result1;
    }
    /**
     * @param map
     *  成绩           学生id
     *  考试结束了，把总分更新到数据库
     */
    @Override
    public int saveScore(Map map) throws Exception {
        int result = ieDao.saveScore2(map);
        int scoreExam = Integer.parseInt(map.get("total").toString());
        int studentId = Integer.parseInt(map.get("studentId").toString());
        return 0;
    }
    //返回一个对象   默认加载
    @Override
    public StudentEnterModel quertstusss(int enterId) throws Exception {  
        StudentEnterModel StudentEn= ieDao.selectStuEnterModel(enterId);
        return StudentEn;
    }
    /**
     * 缴费之后，把报名表的数据录入学生表
     */
    @Override
    @Transactional
    public int quertstu(String username, String enterIdcard, double enterPayMoney, String enterPayWay1) throws Exception {
       if(enterPayWay1.equals("微信")){
           int enterPayWay = 1;
           int updates = ieDao.updateStuEnterModelaaa(enterIdcard, enterPayMoney, enterPayWay);
           if (updates > 0) {
               StudentEnterModel student = ieDao.selectStuEnterModelaaa(enterIdcard);
               int result = Copy.StudentEnterModelaaaa(student, username);
               return result;
           }
       }else if(enterPayWay1.equals("支付宝")){
           int enterPayWay = 2;
           int updates = ieDao.updateStuEnterModelaaa(enterIdcard, enterPayMoney, enterPayWay);
           if (updates > 0) {
               StudentEnterModel student = ieDao.selectStuEnterModelaaa(enterIdcard);
               int result = Copy.StudentEnterModelaaaa(student, username);
               return result;
           }
       }
        return 0;
    }
}
