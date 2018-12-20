package com.dessert.sys.dao;

import org.apache.ibatis.annotations.Param;

public interface UserOrdersDao {
	// 根据用户id删除订单
	int deleteObjectsByUserId(Integer userId);
	
	int deleteObjectsByOrdersId(@Param("ids")Integer... ordersId);	
}