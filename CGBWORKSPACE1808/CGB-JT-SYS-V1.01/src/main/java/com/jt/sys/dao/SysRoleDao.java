package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysRole;
import com.jt.sys.vo.SysRoleVo;

/**
 * 1) 接收业务层参数数据
 * 2) 基于参数进行数据查询
 * 3) 将查询结果进行封装
 * 4) 将结果返回给业务层对象
 * @author Administrator
 *
 */
public interface SysRoleDao {
	/**
	 * 基于角色更新数据库信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysRole entity);
	/**
	 * 基于id查询角色以及角色对应的菜单信息
	 * @param id
	 * @return
	 */
	SysRoleVo findObjectById(Integer id);

	/**
	 * 分页查询角色信息
	 * @param name 角色名称
	 * @param startIndex 上一页的结束位置
	 * @param pageSize 每页要查询的记录数
	 * @return
	 */
	List<SysRole> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 基于name条件查询总记录数
	 * @param name
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	/**
	 * 基于id条件删除角色信息
	 * @param id
	 * @return
	 */
	int deleteObject(@Param("id")Integer id);
	/**
	 * 插入角色自身信息
	 * @param entity
	 * @return
	 */
	int insertObject(SysRole entity);
}
