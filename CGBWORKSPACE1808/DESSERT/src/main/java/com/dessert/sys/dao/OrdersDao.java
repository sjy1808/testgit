package com.dessert.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dessert.sys.orders.entity.Orders;

public interface OrdersDao {
	List<Orders> findPageObjects(@Param("number") String number, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);

	int getRowCount(@Param("number") String number);
	
	int deleteObjects(@Param("ids")Integer...ids);
	
	int deleteObjectsByUserId(@Param("id")Integer id);
}