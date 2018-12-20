package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuDao {

	/**
	 * 基于角色id查找菜单id
	 * @param roleIds
	 * @return
	 */
	List<Integer> findMenuIdsByRoleIds(
			@Param("roleIds")Integer[] roleIds);

	/**
	 * 基于菜单id删除菜单和角色的关系
	 * @param id
	 * @return
	 */
	int deleteObjectsByMenuId(Integer id);
	/**
	 * 基于角色id删除角色与菜单的关系数据
	 * @param roleId
	 * @return
	 */
	int deleteObjectsByRoleId(Integer roleId);
	/**
	 * 插入角色菜单关系数据
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	int insertObject(@Param("roleId")Integer roleId,@Param("menuIds")Integer[] menuIds);
}
