package com.pt.order.dao;

import java.util.List;

import com.pt.order.entity.Order;
import com.pt.order.vo.OrderVo;
import com.pt.order.vo.SqlOrderCommand;

public interface OrderDao {

	List<OrderVo> findPageObjects();
	List<Order> findPageObject(SqlOrderCommand orderCommand);
	int insertObject(Object entity);
	int insertObjects(Integer id);
}
