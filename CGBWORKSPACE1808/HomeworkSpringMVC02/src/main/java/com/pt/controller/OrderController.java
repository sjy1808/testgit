package com.pt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/order/")
public class OrderController {

	//创建构造方法,来看OrderController这个类是什么时候创建的,因为在新建这个类的时候一定用到构造方法
	public OrderController(){
		System.out.println("OrderController");
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public String doDeleteObject(String id){
		if(id==null||"".equals(id))throw new IllegalArgumentException();
		Integer code=Integer.parseInt(id);
		return "delete ok,code="+code;
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public String doSaveObject(){
		System.out.println("doSaveObject");
		return "save order ok";
	}
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String doHandleRuntimeException(RuntimeException e){
		System.err.println("OrderController.doHandleRuntimeException");
		return e.getMessage();
	}
}
