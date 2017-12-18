package com.education.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.dao.RoleDao;
import com.education.model.ResultDo;
import com.education.model.RoleModel;
import com.education.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
		
	/**
	 * 注入角色数据层接口
	 */
	@Autowired
	private RoleDao roleDao;
	/**
	 * 查询所有角色
	 * @return 	ResultDo<Object> 所有角色信息(统一返回值信息)
	 * @throws Exception 抛出数据层异常
	 */
	public ResultDo<Object> listAllRole() throws Exception{
		//生成统一返回值类型数据
		ResultDo<Object> rs=new ResultDo<Object>();
		//查询数据
		List<RoleModel> list = roleDao.listAllRole();
		Map<String,Object> map=new HashMap<String,Object>();
		//将数据添加到统一返回值类型
		map.put("list", list);
		rs.setResData(map);
		//添加提示信息
		rs.setResMsg("查询成功");
		return rs;
		
	}

	/**
	 * 添加角色信息
	 * @param roleModel 角色实体
	 * @return 	ResultDo<Object> 影响的行数(统一返回值信息)
	 * @throws Exception 抛出数据层异常
	 */
	public ResultDo<Object>  addRole(RoleModel roleModel) throws Exception {
		//生成统一返回值类型数据
		ResultDo<Object> rs=new ResultDo<Object>();
		//添加数据
		Integer temp=roleDao.addRole(roleModel);
		//添加失败处理
		if(temp==null||temp<1){
			rs.setResCode(100);
			rs.setResMsg("添加失败");
			return rs;
		}
		//添加成功处理
		rs.setResCode(0);
		rs.setResMsg("添加成功");
		rs.setResData(temp);
		return rs;
	}
	/**
	 * 修改角色信息
	 * @param roleModel 角色实体
	 * @return 	ResultDo<Object> 返回影响的行数(统一返回值信息)
	 * @throws Exception 抛出数据层异常
	 */
	public ResultDo<Object>  updateRole(RoleModel roleModel)throws Exception {
		//生成统一返回值类型数据
		ResultDo<Object> rs=new ResultDo<Object>();
		//修改数据
		Integer temp=roleDao.updateRole(roleModel);
		//修改失败处理
		if(temp==null||temp<1){
			rs.setResCode(100);
			rs.setResMsg("修改失败");
			return rs;
		}
		//修改成功处理
		rs.setResCode(0);
		rs.setResMsg("修改成功");
		rs.setResData(temp);
		return rs;		
	}
	
	/**
	 * 根据编号删除角色信息
	 * @param roleId 权限编号
	 * @return 	ResultDo<Object> 返回影响的函数(统一返回值信息)
	 * @throws Exception 抛出数据层异常
	 */
	 
	public ResultDo<Object>  deleteRole(Integer roleId)throws Exception {
		//生成统一返回值类型数据
		ResultDo<Object> rs=new ResultDo<Object>();
		//修改数据
		Integer temp=roleDao.deleteRole(roleId);
		//修改失败处理
		if(temp==null||temp<1){
			rs.setResCode(100);
			rs.setResMsg("删除失败");
			return rs;
		}
		//修改成功处理
		rs.setResCode(0);
		rs.setResMsg("删除成功");
		rs.setResData(temp);
		return rs;	
	}
}
