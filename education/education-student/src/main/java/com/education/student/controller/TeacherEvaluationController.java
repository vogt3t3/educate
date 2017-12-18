package com.education.student.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ErrorCode;
import com.education.model.TeaEvaluationModel;
import com.education.service.TeacherEvaluationService;
import com.education.service.exception.ServiceException;
import com.education.model.ResultDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 教师评价控制层
 * @author FYM
 * @param <T>
 *
 */
@Api(value="/api/student",description="学生评价的相关操作")
@RestController
@RequestMapping("/api/student")
public class TeacherEvaluationController<T> {
   
    /**
     *教师评价服务层接口 
     */
    @Reference
    private TeacherEvaluationService teacherEvaluationService;
    
    /**
     * 返回学生评价集合. 
     * @param stuId 学生id
     * @param teaId 教师id
     * @return 学生评价集合
     * @throws Exception 抛出异常
     */
    @ApiOperation(notes="teacherEvaluatelist",httpMethod="GET",value="返回学生评价集合")
    @RequestMapping(path ="/teacherEvaluatelist", method = RequestMethod.GET)
    public ResultDo<List<TeaEvaluationModel>> getTeaEvaList(Integer stuId, Integer teaId) throws Exception{
        List<TeaEvaluationModel> teaEvaList=teacherEvaluationService.queryTeaEvaluationList(stuId, teaId);
        ResultDo<List<TeaEvaluationModel>> resultDo =new ResultDo<List<TeaEvaluationModel>>();
        resultDo.setResCode(0);
        resultDo.setResMsg("请求成功");
        resultDo.setResData(teaEvaList);
        return resultDo;
    }
    
    /**
     * 添加学生评价信息
     * @param teaEvaluationModel 学生评价类
     * @return ResultDo<T>
     * @throws ServiceException 抛出异常
     */
    @ApiOperation(notes="addTeaEvaluationModel",httpMethod="POST",value="添加学生评价信息")
    @RequestMapping(path="/addTeaEvaluationModel",method = RequestMethod.POST)
    public ResultDo<T> addTeaEvaluationModel(@RequestBody TeaEvaluationModel teaEvaluationModel) throws ServiceException{
        int count=teacherEvaluationService.addTeaEvaluation(teaEvaluationModel);
        ResultDo<T> resultDo =new ResultDo<T>();
        resultDo.setResCode(0);
        resultDo.setResMsg("添加成功");
        if(count==0){
            throw new ServiceException(ErrorCode.SYS_ERROR);
        }
        return resultDo;
    }
    
}
