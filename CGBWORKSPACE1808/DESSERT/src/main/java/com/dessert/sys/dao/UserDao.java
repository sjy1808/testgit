package com.dessert.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dessert.sys.orders.entity.User;
import com.dessert.sys.vo.UserOrders;

public interface UserDao {


	/* 根据前台页面登录获取用户信息 */
	User findUserByUserName(String username);

	/**
	 * 负责将用户信息更新到数据库
	 * 
	 * @param entity
	 * @return
	 */
	int updateObject(User entity);

	/**
	 * 负责将用户信息写入到数据库
	 * 
	 * @param entity
	 * @return
	 */
	int insertObject(User entity);

	User findObjects(Integer id);

	/**
	 * 依据条件执行分页查询操作
	 * 
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<UserOrders> findPageObjects(@Param("username") String username, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	/** 依据条件统计记录总数 */
	int getRowCount(@Param("username") String username);

	/* 删除用户 */
	int deleteObjects(Integer id);
}