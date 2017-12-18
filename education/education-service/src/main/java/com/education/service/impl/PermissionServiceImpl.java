package com.education.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.education.dao.PermissionDao;
import com.education.model.PageModel;
import com.education.model.PermissionModel;
import com.education.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 杨振欣 查询权限业务实现
 * @author Administrator
 *
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    /**
     * 注入权限查询数据层接口层
     */
    @Autowired
    private PermissionDao permissionDao;
    /**
     * 杨振欣 查询权限业务实现
     * @author Administrator
     * @throws Exception 抛出底层异常
     *
     */
    @Override
    public PageInfo<PermissionModel> listPermission(Integer pageNo, Integer pageSize) throws Exception {
    	pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
        //开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        //将结果查询出来
        List<PermissionModel> list=permissionDao.listPermission();
        //将查询结果传给PageInfo对象
        PageInfo<PermissionModel> page = new PageInfo<PermissionModel>(list);
        return page;
    }
    /** 添加权限
     * @param model 权限对象
     * @return Integer
     * @throws Exception 抛出底层异常
     */
	@Override
	public Integer addPermission(PermissionModel model) throws Exception {
		Integer sum=permissionDao.addPermission(model);
		return sum;
	}
    /**
     * @param model 修改的对象信息
     * @return 返回影响的行数
     * @throws Exception 抛出底层异常
     */
	@Override
	public Integer updatePermission(PermissionModel model) throws Exception {
		Integer sum=permissionDao.updatePermission(model);
		return sum;
	}
    /**
     * @param permissionId 传入权限的编号
     * @return 返回影响的行数
     * @throws Exception 抛出底层异常
     */
	@Override
	public Integer deletePermission(Integer permissionId) throws Exception {
		Integer sum=permissionDao.deletePermission(permissionId);
		return sum;
	}
    /**
     * @param pageModel 传入分页实体
     * @return PageInfo<PermissionModel> 查询的权限列表
     * @throws Exception 抛出底层异常
     */
    public PageInfo<PermissionModel>  getPermissonByRoleId(PageModel pageModel)throws Exception {
    	Integer pageNo=pageModel.getPageNo();
    	Integer pageSize=pageModel.getPageSize();
    	pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
      	//开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        //将结果查询出来
        List<PermissionModel> list=permissionDao.getPermissonByRoleId(pageModel.getRoleId());
        PageInfo<PermissionModel> page = new PageInfo<PermissionModel>(list);
		return page;
	} 
    /**
     * @param pageModel 传入分页实体
     * @return PageInfo<PermissionModel> 查询的权限列表
     * @throws Exception 抛出底层异常
     */
    public PageInfo<PermissionModel>  getPermissonByRoleIdNo(PageModel pageModel) throws Exception {
    	Integer pageNo=pageModel.getPageNo();
    	Integer pageSize=pageModel.getPageSize();
    	pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?3:pageSize;
      	//开启分页 参数为当前页和数据条数
        PageHelper.startPage(pageNo, pageSize);
        //将结果查询出来
        List<PermissionModel> list=permissionDao.getPermissonByRoleIdNo(pageModel.getRoleId());
        PageInfo<PermissionModel> page = new PageInfo<PermissionModel>(list);
		return page;
	}
	@Override
	
    /**
     * 给指定角色赋予指定的权限
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return 返回影响的行数
     * @throws Exception 抛出底层异常
     */
	public Integer addRolePermission(Integer roleId,Integer permissionId)throws Exception{
		//判断角色权限表中是否有该权限（被删除权限）
		Integer id=permissionDao.getPermissionHave(roleId, permissionId);
		Integer sum=null;
		if(id==null){
			sum=permissionDao.addRolePermission(roleId, permissionId);
		}else{
			sum=permissionDao.updateRolePermission(id);
		}
		return sum;
	}
    /**
     * 移除某个角色的某个权限
     * @param roleId 角色编号
     * @param permissionId 权限编号
     * @return 返回影响的行数
     * @throws Exception 抛出底层异常
     */
	public Integer removeRolePermission(Integer roleId,Integer permissionId)throws Exception{
		//删除指定用户的指定的权限
		Integer sum=permissionDao.removeRolePermission(roleId, permissionId);
		return sum;
	}

}
