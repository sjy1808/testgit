package com.jt.sys.dao;

public interface SysRoleMenuDao {

	/**
	 * 依据menuId删除sys_role_menus表中的角色菜单关系数据
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);
}
