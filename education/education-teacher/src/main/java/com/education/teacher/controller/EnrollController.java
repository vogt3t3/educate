package com.education.teacher.controller;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.EnrollStudents;
import com.education.model.ResultDo;
import com.education.service.IEnrollServiceApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 李志鹏
 *
 */
@Api(value = "/api/manger", description = "招生计划")
@RestController
@RequestMapping("/api/manger")
public class EnrollController {

	@Reference
	private IEnrollServiceApi enroll;
	/**
	 * 根据当前页决定显示数据
	 * @throws Exception 
	 */
	@ApiOperation(notes = "/enroll/page", httpMethod = "GET", value = "招生计划分页")
    @RequestMapping(value="/enroll/page",method=RequestMethod.GET)
    public ResultDo<Object> getPage(Integer currentPage,Integer searchMessage) throws Exception{
//    System.out.println("sssssss"+currentPage);
        currentPage = currentPage == null?1:currentPage;
        @SuppressWarnings("unchecked")
        Map<Object,Object> map=enroll.getEnrollS(currentPage,searchMessage);
        ResultDo<Object> result = new ResultDo<Object>();
        result.setResData(map);
        
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;
    }
	
	
	   /** 添加用户信息
	 * @param enrollsStudents
	 * @return 信息代码
	 * @throws Exception
	 */
        @ApiOperation(notes = "/enroll/add", httpMethod = "POST", value = "添加招生计划")
        @RequestMapping(value="/enroll/add",method=RequestMethod.POST)
        public ResultDo<Object> addEnrollController(@RequestBody EnrollStudents enrollsStudents) throws Exception{
        enroll.addEnrolls(enrollsStudents);
	    ResultDo<Object> result = new ResultDo<Object>();
        result.setResMsg("请求成功");
        result.setResCode(0);
        return result;
        }
        /** 修改用户信息,根据招生id返回招生信息学
         * @param enrollsStudents
         * @return 信息代码
         * @throws Exception
         */
            @ApiOperation(notes = "/enroll/getenroll", httpMethod = "POST", value = "根据编号查询对象")
            @RequestMapping(value="/enroll/getenroll",method=RequestMethod.POST)
            public ResultDo<Object> getUpdateEnroll(@RequestBody EnrollStudents enrollsStudents) throws Exception{
//                System.out.println("编号"+enrollsStudents.getEnroll_id());
                EnrollStudents es=enroll.SelectEnroll(enrollsStudents.getEnroll_id());
                ResultDo<Object> result = new ResultDo<Object>();
                result.setResMsg("请求成功");
                result.setResCode(0);
                result.setResData(es);
                return result;
            }
            
            /** 更新招生信息
             * @param enrollsStudents
             * @return 信息代码
             * @throws Exception
             */
            @ApiOperation(notes = "/enroll/update", httpMethod = "POST", value = "更新招生计划内容")
            @RequestMapping(value="/enroll/update",method=RequestMethod.POST)
            public ResultDo<Object> UpdateEnrollController(@RequestBody EnrollStudents enrollsStudents) throws Exception{
               System.out.println("编号"+enrollsStudents.getEnroll_id()+"sssss"+enrollsStudents.getEnrollStudentNum());
                enroll.UpdateEnrolls(enrollsStudents);
                ResultDo<Object> result = new ResultDo<Object>();
                result.setResMsg("请求成功");
                result.setResCode(0);
                return result;
            }
            
            
            @ApiOperation(notes = "/enroll/delete", httpMethod = "POST", value = "删除招生计划")
            @RequestMapping(value="/enroll/delete",method=RequestMethod.POST)
            public ResultDo<Object> deleteEnrollController(@RequestBody EnrollStudents enrollsStudents) throws Exception{
            enroll.DeleteEnroll(enrollsStudents.getEnroll_id());
            ResultDo<Object> result = new ResultDo<Object>();
            result.setResMsg("请求成功");
            result.setResCode(0);
            return result;
            }
            
}
