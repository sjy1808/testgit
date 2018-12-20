package com.dessert.sys.service;

import java.util.List;

import com.dessert.sys.orders.entity.Shopcart;

 

public interface CartService {
	int addCart(Shopcart shopcart);
	List<Shopcart> findShopcarts(String name);
	
	int deleteCarts(String username);
	
}
