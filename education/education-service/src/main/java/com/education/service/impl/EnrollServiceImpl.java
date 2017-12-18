package com.education.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.MangerEnrollDao;
import com.education.model.Courseware;
import com.education.model.EnrollStudents;
import com.education.model.MajorModel;
import com.education.service.IEnrollServiceApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理分页 的服务层
 * @author 李志鹏
 *
 */
@Service
public class EnrollServiceImpl implements IEnrollServiceApi{
    
    @Autowired
    private MangerEnrollDao med;
    
    /** 分页数据 默认初始化 查询所有信息,查询Select里面的值
     * @return EnrollStudentsModel实例化对象
     * @throws Exception
     */
    @Override
    public Map<Object,Object> getEnrollS(Integer currentPage,Integer searchMessage) throws Exception {
        Map<Object,Object> map = new HashMap<Object,Object>();
        PageHelper.startPage(currentPage, 10);
        List<EnrollStudents> listEnro= med.queryEnrollStudent(searchMessage);
        List<MajorModel> listMajor = med.queryMajorModel();
        PageInfo<EnrollStudents> page = new PageInfo<EnrollStudents>(listEnro);
        map.put("listEnro", page);
        map.put("listMajor", listMajor);
        return map;
    }

    /** 添加招生计划，传入对象当参数
     * @return EnrollStudentsModel实例化对象
     * @throws Exception
     */
    @Override
    public void addEnrolls(EnrollStudents enrollsStudents) throws Exception {
        enrollsStudents.setEnrollCreateDate(new Date());
        enrollsStudents.setEnrollModifyDate(new Date());
       enrollsStudents.setEnrollModifyPerson("李志鹏");
       med.addEnroll(enrollsStudents);
    }

    /** 根据id找到对象
     * @return EnrollStudentsModel实例化对象
     * @throws Exception
     */
    @Override
    public EnrollStudents SelectEnroll(Integer enroll_id) throws Exception {
        EnrollStudents enrollStudents= med.queryEnrollStudentId(enroll_id);
        return enrollStudents;
    }
    /** 更新数据内容
     * @throws Exception
     */
    @Override
    public void UpdateEnrolls(EnrollStudents enrollsStudents) throws Exception {
        enrollsStudents.setEnrollModifyDate(new Date());
        med.updateEnrollStudent(enrollsStudents);
        
    }
    /** 删除数据内容
     * @throws Exception
     */
    @Override
    public void DeleteEnroll(Integer enroll_id) throws Exception {
        // TODO Auto-generated method stub
        med.deleteEnrollStudent(enroll_id);
    }

   

    
 
    
    
}
