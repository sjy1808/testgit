package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.Syslog;

public interface SysLogDao {

	/**
	 * 就查询条件查询当前页数据
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Syslog> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**按用户名获取记录总数
	 * 当dao接口方法中的参数应用在mybatis的动态sql中时,
	 * 无论方法中的参数有几个,都要使用@Param注解对参数进行定义
	 * */
	int getRowCount(@Param("username")String username);
	/**
	 * 基于日志id执行日志的删除操作
	 * @param ids
	 * @return
	 */
	int deleteObjects(@Param("ids")Integer... ids);
	/**
	 * 将日志信息持久化到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(Syslog entity);
}
