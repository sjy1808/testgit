package com.dessert.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dessert.sys.orders.entity.SysGoods;


public interface SysGoodsDao {

	
	
	int insertObject(SysGoods entity);
	
	List<SysGoods>findPageObjects(
			@Param("name")String name ,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	List<SysGoods>findPageObjectsByCategory(
			@Param("category")String category );
	
	
	
	int getRowCount(@Param("name")String name);
	int getRowCountcategory(@Param("category")String namcategorye);
	
	int deleteGoods(Integer id);
	
	SysGoods findObjectById(Integer id);
	
	int updateObject(SysGoods entity);
	
	
}
