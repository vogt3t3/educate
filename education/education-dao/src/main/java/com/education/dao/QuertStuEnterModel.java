package com.education.dao;

import org.apache.ibatis.annotations.Param;
import com.education.model.StudentEnterModel;

public interface QuertStuEnterModel {
    /**
     * 按身份证查询查询信息
     * 
     * @param enterIdcard
     * @return
     */
    StudentEnterModel selectEnterModel(int enterId);

    /**
     * 按身份证查询查询信息
     * 
     * @param enterIdcard
     * @return
     */
    StudentEnterModel selectStuEnterModel(String enterIdcard);

    /**
     * 按身份证修改信息(交过费之后修改缴费金额和缴费状态、缴费方式)
     * 
     * @param enterIdcard
     * @return
     */
    int updateStuEnterModel(@Param("enterIdcard") String enterIdcard, @Param("enterPayMoney") double enterPayMoney,
            @Param("enterPayWay") Integer enterPayWay);

}
