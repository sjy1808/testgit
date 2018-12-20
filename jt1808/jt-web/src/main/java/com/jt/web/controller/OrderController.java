package com.jt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.po.Cart;
import com.jt.common.po.Order;
import com.jt.common.vo.SysResult;
import com.jt.web.service.CartService;
import com.jt.web.service.OrderService;
import com.jt.web.thread.UserThreadLocal;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	//实现订单确认页面的跳转
	@RequestMapping("/create")
	public String create(Model model){
		Long userId=UserThreadLocal.get().getId();
		List<Cart> carts=cartService.findCartByUserId(userId);
		model.addAttribute("carts", carts);
		return "order-cart";
	}
	@RequestMapping("/submit")
	@ResponseBody
	public SysResult saveOrder(Order order){
		//前台要求获取orderId之后进行页面跳转
		try {
			Long userId=UserThreadLocal.get().getId();
			order.setUserId(userId);
			String orderId=orderService.saveOrder(order);
			if(!StringUtils.isEmpty(orderId)){
				return SysResult.oK(orderId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "订单提交失败!");
	}
	//根据orderId查询订单信息Order{orderShipping,List<OrderItem>}
	@RequestMapping("/success")
	public String success(String id,Model model){
		try {
			Order order=orderService.findOrderById(id);
			model.addAttribute("order", order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
}