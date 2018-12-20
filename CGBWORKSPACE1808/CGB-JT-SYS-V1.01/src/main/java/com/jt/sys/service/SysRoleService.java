package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysRole;
import com.jt.sys.vo.SysRoleVo;
/**
 * 分页查询数据并对数据进行封装
 * @author Administrator
 *
 */
public interface SysRoleService {

	/**
	 * 本方法中要分页查询角色信息,并查询角色总记录数据
	 * @param name 角色信息
	 * @param pageCurrent 当表要查询的当前页的页码值
	 * @return 封装当前实体数据以及分页信息
	 */
	PageObject<SysRole> findPageObjects(String name,Integer pageCurrent);
	/**
	 * 基于角色id执行删除操作
	 * 1.角色自身信息
	 * 2.角色菜单关系数据
	 * 3.角色用户关系数据
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	/**
	 * 向数据库保存数据
	 * 1.保存角色自身信息
	 * 2.保存角色和菜单之间的关系数据
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int saveObject(SysRole entity,Integer[] menuIds);
	/**
	 * 向数据库修改并保存数据
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int updateObject(SysRole entity,Integer[] menuIds);
	/**
	 * 基于角色id查询角色自身信息以及与菜单关联的数据信息
	 * @param id
	 * @return
	 */
	SysRoleVo findObjectById(Integer id);
}
