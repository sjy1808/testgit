package com.dessert.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dessert.sys.orders.entity.Shopcart;



public interface ShopcartDao {
	public int addCart(Shopcart shopcart);
	public int updateCart(@Param("name")String name,@Param("number")int number,@Param("totalprice") double totalprice);
	public Integer findShopcart(@Param("name")String name,@Param("username")String username);
	public List<Shopcart> findShopcarts(@Param("username")String username);
	
	
	public int deleteCarts(@Param("username")String username);
}
