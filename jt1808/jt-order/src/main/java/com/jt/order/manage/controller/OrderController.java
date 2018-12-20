package com.jt.order.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.po.Order;
import com.jt.common.vo.SysResult;
import com.jt.order.manage.service.OrderService;

@RestController//要求后台返回数据都是json
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	private ObjectMapper objectMapper=new ObjectMapper();
	//实现订单入库
	@RequestMapping("/create")
	public SysResult saveOrder(String orderJSON){
		try {
			System.out.println(orderJSON);
			Order order=objectMapper.readValue(orderJSON, Order.class);
			String orderId=orderService.saveOrder(order);
			if(!StringUtils.isEmpty(orderId)){
				return SysResult.oK(orderId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "订单提交失败!");
	}
	//根据订单id查询
	@RequestMapping("/query/{id}")
	public Order findOrderById(@PathVariable String id){
		Order order=orderService.findOrderById(id);
		return order;
	}
	
}
