package com.education.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.education.dao.MajorDao;
import com.education.model.MajorModel;
import com.education.service.IMajorServiceApi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 用户服务
 * MajorSerciceApi实现类
 * @author 赵睿慷
 *
 */
@Service
public class MajorServiceApiImpl implements IMajorServiceApi{
    
	/**
	 * 注入数据层接口MajorDao接口
	 */
    @Autowired
    private MajorDao majorDao;
    
    /**
     * 引入log4j日志记录
     */
    private static Logger logger = Logger.getLogger(MajorServiceApiImpl.class.getName());
    
	/**
	 * 实现MajorSerciceApi中的查询方法
	 */
    @Override
	public PageInfo<MajorModel> selectMajorByMajorid(String majorName,Integer majorId,Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<MajorModel> list = majorDao.selectMajorByMajorid(majorName,majorId);
        PageInfo<MajorModel> page = new PageInfo<MajorModel>(list);
        return page;
    }
    /**
     * 实现MajorSerciceApi中的增加方法
     */
    @Override
    public int addMajorByMajorid(MajorModel majorModel) {
        // TODO Auto-generated method stub
        int add = majorDao.addMajorByMajorid(majorModel);
        System.out.println("111111:"+add);
        return add;
    }
    /**
     * 实现MajorSerciceApi中的删除方法
     */
    @Override
    public int deleteMajorById(int majorId) {
        // TODO Auto-generated method stub
        int del = majorDao.deleteMajorById(majorId);
        return del;
    }
    /**
     * 实现MajorSerciceApi中的修改方法
     */
    @Override
    public int updateMajorByMajorid(MajorModel majorModel) {
        // TODO Auto-generated method stub
        int update  = majorDao.updateMajorByMajorid(majorModel);
        return update;
    }
}
