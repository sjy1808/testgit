package com.tedu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.tedu.service.OrderService;
//注册为 Dubbo 服务，注解service是dubbo包的，不是spring包的
@Service(version="1.0.0",timeout=1000000)
public class OrderServiceImpl implements OrderService{

	@Override
	public String findOrderById(Long userId) {
		
		return "第1版  provider userID="+userId;
	}

}
