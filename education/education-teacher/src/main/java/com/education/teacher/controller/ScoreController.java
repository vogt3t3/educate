package com.education.teacher.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.ErrorCode;
import com.education.model.StudentScoreModel;
import com.education.service.ScoreService;
import com.education.service.exception.ServiceException;
import com.education.model.ResultDo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 学生成绩（控制层）
 * @author 冯云威
 * @param <T> 泛型
 */
@Api(value="/api/master",description="学生成绩的相关操作")
@RestController
@RequestMapping("/api/master")
public class ScoreController<T> {
    
    /**
     * 学生成绩
     * 服务层接口
     */
    @Reference
    private ScoreService scoreService;
    
    /**
     * 获取学生成绩的信息
     * @param studentId 模糊查询（根据学生id） 
     * @param studentName 模糊查询（根据学生姓名）
     * @param pageNo 当前页 
     * @param pageSize 一页显示多少条数据
     * @return ResultDo<PageInfo<StudentScoreModel>>
     * @throws Exception 抛出异常
     */
    @ApiOperation(notes="queryScore",httpMethod="GET",value="获取学生成绩的信息")
    @RequestMapping(path ="/queryScore", method = RequestMethod.GET)
    public ResultDo<PageInfo<StudentScoreModel>> getScoreInfoList(Integer studentId,String studentName, @RequestParam("pageNum") Integer pageNo, Integer pageSize) throws Exception{
        PageInfo<StudentScoreModel> page=scoreService.queryByPage(studentId,studentName,pageNo,pageSize);
        ResultDo<PageInfo<StudentScoreModel>> resultDo = new ResultDo<PageInfo<StudentScoreModel>>();
        resultDo.setResCode(0);
        resultDo.setResMsg("请求成功");
        resultDo.setResData(page);
        return resultDo;
    }
    
    
    /**
     * 获取单个学生的详细成绩信息
     * @param scoreId 学生成绩id
     * @return 单个学生成绩详情
     * @throws Exception 抛出异常
     */
    @ApiOperation(notes="queryScoreInfo",httpMethod="GET",value="获取单个学生成绩的详细信息")
    @RequestMapping(path ="/queryScoreInfo", method = RequestMethod.GET)
    public ResultDo<StudentScoreModel> getScoreInfo(Integer scoreId) throws Exception{
        StudentScoreModel stuScore=scoreService.getStuScore(scoreId);
        ResultDo<StudentScoreModel> resultDo = new ResultDo<StudentScoreModel>();
        resultDo.setResCode(0);
        resultDo.setResMsg("请求成功");
        resultDo.setResData(stuScore);
        return resultDo;
    }
    
    /**
     * 修改单个学生成绩
     * @param studentScoreModel 学生成绩信息
     * @return ResultDo<T>
     * @throws ServiceException 抛出异常
     */
    @ApiOperation(notes="updateScore",httpMethod="POST",value="修改单个学生成绩的详细信息")
    @RequestMapping(path="/updateScore",method = RequestMethod.POST)
    public ResultDo<T> updateStuScore(@RequestBody StudentScoreModel studentScoreModel) throws ServiceException{
        int count=scoreService.updateScore(studentScoreModel);
        ResultDo<T> resultDo =new ResultDo<T>();
        resultDo.setResCode(0);
        resultDo.setResMsg("修改成功");
        if(count==0){
            throw new ServiceException(ErrorCode.SYS_ERROR);
        }
        return resultDo;
    }
    
    /**
     * 添加学生成绩
     * @param studentScoreModel 学生成绩信息
     * @return ResultDo<T>
     * @throws Exception 抛出异常
     */
    @ApiOperation(notes="addScore",httpMethod="POST",value="添加学生成绩的详细信息")
    @RequestMapping(path="/addScore",method = RequestMethod.POST)
    public ResultDo<T> addStuScore(@RequestBody StudentScoreModel studentScoreModel) throws Exception{
        int count=scoreService.addScore(studentScoreModel);
        System.out.println(count);
        ResultDo<T> resultDo =new ResultDo<T>();
        resultDo.setResCode(0);
        resultDo.setResMsg("添加成功");
        if(count==0){
            throw new ServiceException(ErrorCode.SYS_ERROR);
        }
        return resultDo;
    }
}
