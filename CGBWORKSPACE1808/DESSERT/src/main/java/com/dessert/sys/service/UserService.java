package com.dessert.sys.service;

import com.dessert.common.vo.PageObject;
import com.dessert.sys.orders.entity.User;
import com.dessert.sys.vo.UserOrders;


public interface UserService {


	int saveObject(User entity);

	int updateObject(User entity);

	PageObject<UserOrders> findPageObjects(String username, Integer pageCurrent);	
	/*删除用户*/
	int deleteObjects(Integer id);
	
	User findObject(Integer id);
	
	
	User findObjectByUsername(String username);
}