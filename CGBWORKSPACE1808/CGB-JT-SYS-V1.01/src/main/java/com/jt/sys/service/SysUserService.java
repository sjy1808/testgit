package com.jt.sys.service;

import java.util.List;
import java.util.Map;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysUser;
import com.jt.sys.vo.SysUserDeptResult;

public interface SysUserService {

	PageObject<SysUserDeptResult> findPageObjects(
			String username,
			Integer pageCurrent);
	/**
	 * 禁用或启用对象
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(Integer id,
			Integer valid,
			String modifiedUser);
	/**
	 * 查询角色信息,向页面返回
	 * @return
	 */
	List<CheckBox> findObjects();
	/**
	 * 接收客户端数据保存到数据库
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int saveObject(SysUser entity,Integer... roleIds);
	/**
	 * 基于用户id查询用户信息,部门信息以及对应的角色信息,并对查询到的结果数据进行封装
	 * @param userId
	 * @return
	 */
	Map<String,Object> findObjectById(Integer userId);
	/**
	 * 接收客户端的数据,更新数据库的数据
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity,Integer[] roleIds);
	
	
}
