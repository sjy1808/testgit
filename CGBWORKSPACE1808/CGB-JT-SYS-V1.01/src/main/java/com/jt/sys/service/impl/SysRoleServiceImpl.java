package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysRoleDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.dao.SysUserRoleDao;
import com.jt.sys.entity.SysRole;
import com.jt.sys.service.SysRoleService;
import com.jt.sys.vo.SysRoleVo;
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		//1.验证参数合法性
		//1.1验证pageCurrent的合法性,不合法抛出IllegalArgumentException异常
		if(pageCurrent==null||pageCurrent<1)throw new IllegalArgumentException("当前页码不正确!");
		//2.基于条件查询总记录数
		//2.1执行查询
		int rowCount=sysRoleDao.getRowCount(name);
		//2.2验证查询结果,假如结果为0不再执行如下操作
		if(rowCount==0)throw new ServiceException("记录不存在!");
		//3.基于条件查询当前页记录(pageSize定义为2)
		//3.1定义pageSize
		int pageSize=3;
		//3.2计算startIndex
		int startIndex=(pageCurrent-1)*pageSize;
		//3.3执行当前数据的查询操作
		List<SysRole> records = sysRoleDao.findPageObjects(name, startIndex, pageSize);
		//4.对分页信息以及当前记录进行封装
		//4.1构建PageObject对象
		PageObject<SysRole> pageObject = new PageObject<>();
		//4.2封装数据
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);;
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0)pageCount++;
		pageObject.setPageCount(pageCount);
		//5.返回封装结果
		return pageObject;
	}
	@Override
	public int deleteObject(Integer id) {
		//1.验证参数的合法性
		if(id==null||id<1)throw new ServiceException("id的值不正确,id="+id);
		//2.执行dao操作
		int rows=sysRoleDao.deleteObject(id);
		if(rows==0)throw new ServiceException("数据可能已经不存在");
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		sysUserRoleDao.deleteObjectsByRoleId(id);
		//3.返回执行结果
		return rows;
	}
	@Transactional
	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		//1.参数合法性验证
		if(entity==null)throw new ServiceException("保存数据不能为空");
		if(StringUtils.isEmpty(entity.getName()))throw new ServiceException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)throw new ServiceException("必须为角色赋予权限");
		//2.保存数据
		//2.1保存角色的自身信息
		int rows=sysRoleDao.insertObject(entity);
		//2.2保存角色和菜单的关系数据
		int menuRows=sysRoleMenuDao.insertObject(entity.getId(), menuIds);
		//if(menuRows>0)throw new ServiceException("关系数据写入失败");
		//3.返回结果
		return rows;
	}
	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		//1.参数合法性验证
		if(entity==null)throw new ServiceException("更新的数据不能为空");
		if(StringUtils.isEmpty(entity.getName()))throw new ServiceException("角色名不能为空");
		if(menuIds==null||menuIds.length==0)throw new ServiceException("必须为角色赋予权限");
		//2.保存数据
		//2.1保存角色的自身信息
		int rows=sysRoleDao.updateObject(entity);
		//2.2保存角色和菜单的关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		sysRoleMenuDao.insertObject(entity.getId(), menuIds);
		//3.返回结果
		return rows;
	}
	@Override
	public SysRoleVo findObjectById(Integer id) {
		if(id==null||id<1)throw new IllegalArgumentException("id值不正确");
		SysRoleVo srVo = sysRoleDao.findObjectById(id);
		if(srVo==null)throw new ServiceException("数据可能不存在");
		return srVo;
		
	}

}
