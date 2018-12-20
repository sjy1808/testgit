package com.dessert.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dessert.common.vo.JsonResult;
import com.dessert.common.vo.PageObject;
import com.dessert.sys.orders.entity.Orders;
import com.dessert.sys.service.OrdersService;

@Controller
@RequestMapping("/orders/")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("doOrderListUI")
	public String doOrderListUI(){
		return "sys/orders_list";
	}
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(String number,Integer pageCurrent){
		PageObject<Orders> pageObjects = ordersService.findPageObjects(number, pageCurrent);
		return new JsonResult(pageObjects);
	}
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer...ids){
		ordersService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
}