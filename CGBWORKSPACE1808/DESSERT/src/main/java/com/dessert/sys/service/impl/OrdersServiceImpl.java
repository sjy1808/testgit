package com.dessert.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dessert.common.vo.PageObject;
import com.dessert.exception.ServiceException;
import com.dessert.sys.dao.OrdersDao;
import com.dessert.sys.dao.UserOrdersDao;
import com.dessert.sys.orders.entity.Orders;
import com.dessert.sys.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private UserOrdersDao userOrdersDao;

	@Override
	public PageObject<Orders> findPageObjects(String number, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int Count = ordersDao.getRowCount(number);
		if (Count == 0)
			throw new ServiceException("系统没有找到数据");
		int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<Orders> list = ordersDao.findPageObjects(number, startIndex, pageSize);
		PageObject<Orders> pageObject = new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(Count);
		pageObject.setRecords(list);
		pageObject.setPageCount((Count - 1) / pageSize + 1);
		return pageObject;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		if (ids == null || ids.length == 0)
			throw new IllegalArgumentException("请先选择");
		int rows = ordersDao.deleteObjects(ids);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		int c = userOrdersDao.deleteObjectsByOrdersId(ids);
		System.out.println(c);
		return rows;
	}
}