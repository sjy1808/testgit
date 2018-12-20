package com.jt.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.exception.ServiceException;
import com.jt.common.vo.Node;
import com.jt.sys.dao.SysMenuDao;
import com.jt.sys.dao.SysRoleMenuDao;
import com.jt.sys.entity.SysMenu;
import com.jt.sys.service.SysMenuService;
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> pageObjects = sysMenuDao.findObjects();
		if(pageObjects==null||pageObjects.size()==0)throw new ServiceException("可能没有记录!");
		return pageObjects;
	}

	@Override
	public int deleteObject(Integer id) {
		//1.验证参数的合法性
		if(id==null||id<=0)throw new  IllegalArgumentException("请先选择");
		//2.基于id进行子元素查询
		int count=sysMenuDao.getChildCount(id);
		if(count>0)throw new ServiceException("请先删除子菜单");
		//3.删除菜单元素
		int rows=sysMenuDao.deleteObject(id);
		if(rows==0)throw new ServiceException("此菜单可能已经不存在");
		//4.删除角色,菜单关系数据
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		//5.返回结果
		return rows;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> nodes = sysMenuDao.findZtreeMenuNodes();
		return nodes;
	}

	@Override
	public int insertObject(SysMenu entity) {
		//1.参数合法性验证
		if(entity==null)throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))throw new ServiceException("菜单名不能为空");
		if(StringUtils.isEmpty(entity.getUrl()))throw new ServiceException("路径不能为空");
		//2.保存数据
		int rows;
		try {
			rows=sysMenuDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		//3.返回数据
		return rows;
	}

	@Override
	public int updateObject(SysMenu entity) {
		//1.验证参数的合法性
		if(entity==null)throw new IllegalArgumentException("更新的内容不能为空");
		if(StringUtils.isEmpty(entity.getName()))throw new ServiceException("菜单名不能为空");
		if(StringUtils.isEmpty(entity.getUrl()))throw new ServiceException("路径不能为空");
		if(StringUtils.isEmpty(entity.getPermission()))throw new ServiceException("授权信息不能为空");
		//2.更新数据
		int rows;
		try {
			rows=sysMenuDao.updateObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("更新失败!");
		}
		if(rows==0){
			throw new ServiceException("记录可能已经不存在");
		}
		//3.返回数据
		return rows;
	}

}
