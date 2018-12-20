package com.dessert.sys.service;

import com.dessert.common.vo.PageObject;
import com.dessert.sys.orders.entity.Orders;

public interface OrdersService {
	PageObject<Orders> findPageObjects(String number,Integer pageCurrent);
	
	int deleteObjects(Integer...ids);
	
}