package com.tedu.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tedu.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Reference(version="1.0.0",timeout=100000,check=false)
	OrderService orderService;
	@RequestMapping("/find")
	public String find() {
		System.out.println("1");
		String result=orderService.findOrderById(18L);
		return result;
	}


}
