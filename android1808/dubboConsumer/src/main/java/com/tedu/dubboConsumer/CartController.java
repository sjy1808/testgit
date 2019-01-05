package com.tedu.dubboConsumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.service.CartService;

public class CartController {

	public static void main(String[] args) throws Exception {
		//得到CartService的实现类
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-consumer.xml");
		CartService cartService=(CartService) context.getBean("cartService");
		//调用方法
		while(true){
			String str = cartService.findCartByUserId(90L);
			System.out.println(str);
			Thread.currentThread().sleep(1000);
		}
	}
}
