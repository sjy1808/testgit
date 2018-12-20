package com.dessert.sys.service;

import java.util.Map;

import com.dessert.common.vo.PageObject;
import com.dessert.sys.orders.entity.SysGoods;


public interface GoodsService {

	//
	PageObject<SysGoods> findPageObjects( String name,Integer pageCurrent);
	PageObject<SysGoods> findPageObjectsCategory( String category);
	
	
	
	int deleteObject(Integer id);
	
	int saveObject(SysGoods entity);
	
	Map<String,Object>findObjectById(Integer id);
	
	int updateObject(SysGoods entity);
	
}
