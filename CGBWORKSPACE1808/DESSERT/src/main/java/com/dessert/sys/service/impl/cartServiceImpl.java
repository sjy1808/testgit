package com.dessert.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dessert.exception.ServiceException;
import com.dessert.sys.dao.ShopcartDao;
import com.dessert.sys.orders.entity.Shopcart;
import com.dessert.sys.service.CartService;

 
@Service
public class cartServiceImpl implements CartService{

	@Autowired
	private ShopcartDao shopcartDao;
	 
	@Override
	public int addCart(Shopcart shopcart) {
		
		Integer number = shopcartDao.findShopcart(shopcart.getName(),shopcart.getUsername());
		
		System.out.println("number"+number);
		 
		 
		if(number==null){
			shopcartDao.addCart(shopcart);
			 
		}else{
			number = number+1;
			double totalprice = shopcart.getPrice()*number;
			shopcartDao.updateCart(shopcart.getName(), number,totalprice);
		}
		
		return 0;
	}

	@Override
	public List<Shopcart> findShopcarts(String name) {
		List<Shopcart> shopcarts = shopcartDao.findShopcarts(name);
		System.out.println(shopcarts);
		return shopcarts;
	}

	@Override
	public int deleteCarts(String username) {
		if(username ==null){
			throw new ServiceException("请先登录");
		}
		int rows = shopcartDao.deleteCarts(username);
		return rows;
	}

}
