package com.education.teacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.education.model.PageModel;
import com.education.model.PermissionModel;
import com.education.model.ResultDo;
import com.education.service.IPermissionService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 权限管理控制层
 * 
 * @author 杨振欣
 *
 */
@Api(value = "/api/super/permissionManager", description = "权限管理的相关操作")
@RequestMapping("/api/super/permissionManager")
@Controller
public class PermissionController {
    /**
     * 注入业务层接口
     */
    @Reference
    private IPermissionService ipermissionService;
    /**
     * 查询所有的权限 分页展示数据
     * @param  pageModel 分页数据
     * @return  ResultDo<Object> 统一的返回值类型
     * @throws Exception  异常抛出，交给全局异常处理器
     */
    @ApiOperation(notes = "getAllpermission", httpMethod = "POST", value = "获取所有的权限信息")
    @ResponseBody
    @RequestMapping(value="/getAllpermission",method=RequestMethod.POST)
    public ResultDo<Object> listAllPermission(@RequestBody PageModel pageModel) throws Exception{
    	System.out.println(pageModel);
        //查询指定页数的数据
        PageInfo<PermissionModel> list = ipermissionService.listPermission(pageModel.getPageNo(), pageModel.getPageSize());
        ResultDo<Object> rs=new ResultDo<Object>();
        rs.setResData(list);
        return rs;
    }
    /**
     * 超管添加新的权限
     * @param model 添加权限实体
     * @return ResultDo<Object> 统一返回值类型
     * @throws Exception 抛给全局异常处理器
     */
    @ApiOperation(notes = "addPermission", httpMethod = "POST", value = "添加新的权限信息")
    @ResponseBody
    @RequestMapping(value="/addPermission",method=RequestMethod.POST)
    public ResultDo<Object> addPermission(@RequestBody PermissionModel model) throws Exception{
    	System.out.println(model);
    	//调用接口添加权限
    	Integer sum=ipermissionService.addPermission(model);
    	//创建返回值类型数据
    	ResultDo<Object> rs=new ResultDo<Object>();
    	//判断添加是否成功
    	if(sum==null){
    		rs.setResCode(100);
    		rs.setResMsg("添加权限失败");
    	}else{
    		rs.setResCode(0);
    		rs.setResData("添加权限成功");
    	}
    	//返回数据
		return rs;
    }
    /**
     * 修改权限实体
     * @param model 修改传入的权限实体
     * @return 返回统一返回值
     * @throws Exception 抛异常给全局异常处理器
     */
    @ApiOperation(notes = "updatePermisson", httpMethod = "POST", value = "根据编号修改权限信息")
    @ResponseBody
    @RequestMapping(value="/updatePermisson",method=RequestMethod.POST)
    public ResultDo<Object> udatePermission(@RequestBody PermissionModel model)throws Exception{
    	System.out.println(model);
    	//调用接口更新权限
    	Integer sum=ipermissionService.updatePermission(model);
    	ResultDo<Object> rs=new ResultDo<Object>();
    	//判断修改是否成功
    	if(sum==null){
    		rs.setResCode(100);
    		rs.setResMsg("修改权限失败");
    	}else{
    		rs.setResCode(0);
    		rs.setResMsg("修改权限成功");
    	}
		return rs;
    }
    
    /**
     * @param permissionId 传入要删除的权限编号
     * @return 统一返回值类型
     * @throws Exception 抛出异常给全局异常处理器
     */
    @ApiOperation(notes = "deltetePermisson", httpMethod = "GET", value = "根据编号删除权限信息")
    @ResponseBody
    @RequestMapping(value="/deltetePermisson",method=RequestMethod.GET)
    public ResultDo<Object> deltetePermisson(Integer permissionId)throws Exception{
    	System.out.println(permissionId);
    	//调用接口删除权限
    	Integer sum=ipermissionService.deletePermission(permissionId);
    	ResultDo<Object> rs=new ResultDo<Object>();
    	//判断删除是否成功
    	if(sum==null){
    		rs.setResCode(100);
    		rs.setResMsg("删除权限失败");
    	}else{
    		rs.setResCode(0);
    		rs.setResMsg("删除权限成功");
    	}
		return rs;
    }
    /**
     * 查询指定角色编号获取的权限
     * @param  pageModel 分页数据+角色编号
     * @return  ResultDo<Object> 统一的返回值类型
     * @throws Exception  异常抛出，交给全局异常处理器
     */
    @ApiOperation(notes = "getPermissonByRoles", httpMethod = "POST", value = "获取指定角色已经拥有的权限")
    @ResponseBody
    @RequestMapping(value="/getPermissonByRoles",method=RequestMethod.POST)
    public ResultDo<Object> getPermissionByRoleId(@RequestBody PageModel pageModel) throws Exception{
    	System.out.println(pageModel);
        //查询指定页数的数据
        PageInfo<PermissionModel> list = ipermissionService.getPermissonByRoleId(pageModel);
        ResultDo<Object> rs=new ResultDo<Object>();
        rs.setResData(list);
        return rs;
    }
    /**
     * 查询指定角色编号未获取的权限
     * @param  pageModel 分页数据+角色编号
     * @return  ResultDo<Object> 统一的返回值类型
     * @throws Exception  异常抛出，交给全局异常处理器
     */
    @ApiOperation(notes = "getPermissonByRole", httpMethod = "POST", value = "获取指定角色还未拥有的权限")
    @ResponseBody
    @RequestMapping(value="/getPermissonByRole",method=RequestMethod.POST)
    public ResultDo<Object> getPermissionByRoleIds(@RequestBody PageModel pageModel) throws Exception{
    	System.out.println(pageModel);
        //查询指定页数的数据
        PageInfo<PermissionModel> list = ipermissionService.getPermissonByRoleIdNo(pageModel);
        ResultDo<Object> rs=new ResultDo<Object>();
        rs.setResData(list);
        return rs;
    }
    /**
     * 给指定的角色添加指定的权限
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return 统一返回数据类型
     * @throws Exception 抛出异常给全局异常处理
     */
    @ApiOperation(notes = "addRolePermissonById", httpMethod = "GET", value = "给指定的角色添加指定的权限")
    @ResponseBody
    @RequestMapping(value="/addRolePermissonById",method=RequestMethod.GET)
    public ResultDo<Object> addRolrPermission(Integer roleId,Integer permissionId) throws Exception{
    	ResultDo<Object> rs=new ResultDo<Object>();
    	System.out.println("roleId="+roleId+"permissionId="+permissionId);
    	Integer records=ipermissionService.addRolePermission(roleId, permissionId);
    	if(records==null||records==0){
    		rs.setResCode(100);
    		rs.setResMsg("授权失败");
    		return rs;
    	}
    	rs.setResCode(0);
		rs.setResMsg("授权成功");
        return rs;
    }
    /**
     * 给指定的角色添加指定的权限
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return 统一返回数据类型
     * @throws Exception 抛出异常给全局异常处理
     */
    @ApiOperation(notes = "deletePermission", httpMethod = "GET", value = "给指定的角色添加指定的权限")
    @ResponseBody
    @RequestMapping(value="/deletePermission",method=RequestMethod.GET)
    public ResultDo<Object> removeRolrPermission(Integer roleId,Integer permissionId) throws Exception{
    	ResultDo<Object> rs=new ResultDo<Object>();
    	Integer records=ipermissionService.removeRolePermission(roleId, permissionId);
    	if(records==null||records==0){
    		rs.setResCode(100);
    		rs.setResMsg("取消授权失败");
    		return rs;
    	}
    	rs.setResCode(0);
		rs.setResMsg("取消授权成功");
        return rs;
    }
    
    
}
