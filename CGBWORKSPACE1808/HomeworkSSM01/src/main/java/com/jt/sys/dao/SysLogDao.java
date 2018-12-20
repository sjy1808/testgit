package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysLog;

/**
 * 查询当前页显示的数据以及总记录数
 * 1)接收业务层参数数据
 * 2)基于参数进行数据查询
 * 3)将查询结果进行封装
 * 4)将结果返回给业务层对象
 * @author Administrator
 *
 */
public interface SysLogDao {
	
	int deleteObjects(@Param("ids")Integer[] ids);
	/**
	 * 基于条件查询总记录数
	 * @param username 查询条件(例如查询那个用户的日志信息)
	 * @return 总记录数(基于这个结果可以计算总页数)
	 * 说明:假如如下方法没有使用注解修饰,在基于名字进行查询时候会出现
	 * There is no getter for property named 'username' in 'class java.lang.String'
	 * 当Dao方法中的参数应用在动态sql中时无论多少个参数,尽量使用@Param注解进行修饰并定义
	 */
	int getRowCount(@Param("username")String username);
	/**
	 * 基于条件分页查询日志信息
	 * @param username 查询条件(例如查询哪个用户的日志信息)
	 * @param startIndex 当前页的起始位置
	 * @param pageSize 当前页的页面大小
	 * @return 当前页的日志信息记录
	 * 数据库中每条日志信息封装到一个SysLog对象中
	 */
	List<SysLog> findPageObjects(
			@Param("username")String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
}
