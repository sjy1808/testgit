package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 用于操作用户和角色的关系数据
 * @author Administrator
 *
 */
public interface SysUserRoleDao {

	/**
	 * 负责将用户与角色的关系数据写入到数据库中
	 * @param userId 用户id
	 * @param roleIds 多个角色id
	 * @return
	 */
	int insertObjects(@Param("userId")Integer userId,@Param("roleIds")Integer... roleIds);
	/**
	 * 基于角色id删除 用户和角色之间的关系数据
	 */
	int deleteObjectsByRoleId(Integer roleId);
	/**
	 * 基于用户id查询角色id
	 * @param id
	 * @return
	 */
	List<Integer> findRoleIdsByUserId(Integer id);
	/**
	 * 基于用户id删除用户与角色之间的关系数据
	 * @param userId
	 * @return
	 */
	int deleteObjectsByUserId(Integer userId);
	
}
