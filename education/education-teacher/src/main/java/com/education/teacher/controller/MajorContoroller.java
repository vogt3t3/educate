package com.education.teacher.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.MajorModel;
import com.education.model.ResultDo;
import com.education.service.IMajorServiceApi;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 控制层
 * Major专业管理Controller层
 * @author 赵睿慷
 *
 */
@Api(value = "/api/major", description = "专业管理")
@Controller
@RequestMapping("/api/major")
public class MajorContoroller {

    /**
     * 注入用户的业务层
     */
    @Reference
    private IMajorServiceApi msa;
    
    
    /**
     * 引入log4j日志记录
     */
    private static Logger logger = Logger.getLogger(MajorContoroller.class.getName());
    
    /**
     * 查询
     * @param majorName  传入专业名称
     * @param majorId    当前专业id
     * @param pageSize   当前页条数
     * @param pageNum    总页数
     * @return 所有数据
     */
    @ApiOperation(notes = "likeMajors", httpMethod = "GET", value = "查看所有的信息，精确查询模糊查询")
    @RequestMapping(value="/likeMajors",method=RequestMethod.GET)
    @ResponseBody
    public ResultDo<Object> getMajor(String majorName,Integer majorId,Integer pageSize,Integer pageNum){
        System.out.println("控制器1");
        PageInfo<MajorModel> pageInfo=msa.selectMajorByMajorid(majorName,majorId,pageNum,pageSize);
        System.out.println("控制器2");

        System.out.println("111111111:"+pageInfo.getTotal());
        
        List<MajorModel> list = pageInfo.getList();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list", list);
        map.put("total", pageInfo.getTotal());
        System.out.println("111111111:"+list);
        ResultDo<Object> res = new ResultDo<Object>();
        for (MajorModel majorModel : list) {
            System.out.println("majorModel"+majorModel);
        }
        res.setResData(map);
        return res;
    }
    /**
     * @return 测试2
     * @throws Exception
     */
/*    @RequestMapping("/likeMajors")
    @ResponseBody   
    public String listUserByName() {
        System.out.println("44545");
        System.out.println(msa);
        PageInfo<MajorModel> pro = msa.selectMajorByMajorid("lisi", 1, 20);
        List<MajorModel> majorModel=pro.getList();
        for(MajorModel majorModels:majorModel){
            System.out.println(majorModels.getMajorName());
        }
        return "";
    }*/
    
    /**
     * 修改
     * @return int .
     */
    @ApiOperation(notes = "editMajor", httpMethod = "POST", value = "修改专业信息")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @RequestMapping(value="/editMajor",method=RequestMethod.POST)
    @ResponseBody   
    public ResultDo update(@RequestBody MajorModel majorModel){
        //log4j
        logger.info("更新");
        int update = msa.updateMajorByMajorid(majorModel);
        System.out.println("22222:"+update);
        ResultDo rs = new ResultDo();
        //查询出来的内容没有
        if(update == 0){
            rs.setResData("更新失败");
        }
        //有查询出来的内容
        else{
            rs.setResData("更新成功"+update);
        }
        return rs;
    }
    
    /**
     * 增加
     * @param majorModel 传入实体类对象
     * @return 参数.
     */
    @ApiOperation(notes = "add", httpMethod = "POST", value = "添加专业信息")
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResultDo add(@RequestBody MajorModel majorModel){
        int addMajor = msa.addMajorByMajorid(majorModel);
        System.out.println(majorModel);
        ResultDo rs = new ResultDo();
        if (addMajor == 0) {
            rs.setResData("添加失败");
        }
        else {
            rs.setResData("添加成功"+addMajor);
        }
        return rs;
    }
    
    /**
     * 删除信息
     * @return int.
     */
    @ApiOperation(notes = "remove", httpMethod = "GET", value = "删除专业信息")
    @RequestMapping(value="/remove",method=RequestMethod.GET)
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ResponseBody
    public ResultDo delete(int majorId){
        System.out.println("111111111:"+majorId);
        int del = msa.deleteMajorById(majorId);
        System.out.println("-----"+majorId);
        ResultDo rs = new ResultDo();
        if(del == 0){
            rs.setResData("更改失败");
        }
        else{
            rs.setResData("更改成功"+del);
        }
        return rs;
    }
    /**
     * 精确查询id
     * @param majorId 传入专业编号
     * @return int.
     */
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @RequestMapping("/getById")
//    @ResponseBody
//    public ResultDo getById(int majorId){
//        MajorModel majorModel = new MajorModel();
//        majorModel = msa.getById(majorId);
//        ResultDo rs = new ResultDo();
//        if(majorModel == null){
//            rs.setResData("没有该专业");
//        }
//        else{
//            rs.setResData("查找成功"+majorModel);
//        }
//        return rs;
//    }
    
}
