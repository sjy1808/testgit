package com.jt.order.manage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.po.Order;
import com.jt.common.po.OrderItem;
import com.jt.common.po.OrderShipping;
import com.jt.order.manage.mapper.OrderItemMapper;
import com.jt.order.manage.mapper.OrderMapper;
import com.jt.order.manage.mapper.OrderShippingMapper;
import com.jt.order.manage.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;
	@Autowired
	private OrderShippingMapper orderShippingMapper;

	/**
	 * 通过一个order对象,完成3张表入库操作
	 * 订单号:登录用户id+当前时间戳  拼串
	 * 
	 * 业务2:
	 * 	为了防止黑客攻击,造成总价的损失,应该怎么做
	 * 
	 */
	@Override
	public String saveOrder(Order order) {
		String orderId=""+order.getUserId()+System.currentTimeMillis();
		Date date=new Date();
		//1.实现订单入库
		order.setStatus(1);//订单生成    未支付
		order.setOrderId(orderId);
		order.setCreated(date);
		order.setUpdated(date);
		orderMapper.insert(order);
		System.out.println("订单入库成功!");
		//2.实现订单物流入库
		OrderShipping shipping=order.getOrderShipping();
		shipping.setOrderId(orderId);
		shipping.setCreated(date);
		shipping.setUpdated(date);
		orderShippingMapper.insert(shipping);
		System.out.println("订单物流入库成功!");
		//3.实现订单商品信息入库
		List<OrderItem> orderItem = order.getOrderItems();
		for (OrderItem item : orderItem) {
			item.setOrderId(orderId);
			item.setCreated(date);
			item.setUpdated(date);
			orderItemMapper.insert(item);
		}
		System.out.println("订单商品信息入库成功!");
		return orderId;
	}

	@Override
	public Order findOrderById(String id) {
		/**
		 * 1.利用通用mapper进行查询
		 * 2.利用mybatis进行查询
		 * */
		/*1.利用通用mapper进行查询*/
		Order order=orderMapper.selectByPrimaryKey(id);
		OrderShipping orderShipping=orderShippingMapper.selectByPrimaryKey(id);
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(id);
		List<OrderItem> orderItems = orderItemMapper.select(orderItem);
		order.setOrderShipping(orderShipping);
		order.setOrderItems(orderItems);
		return order;
	}
}
