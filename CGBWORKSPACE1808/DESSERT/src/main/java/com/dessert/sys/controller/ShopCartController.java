package com.dessert.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dessert.common.vo.JsonResult;
import com.dessert.sys.orders.entity.Shopcart;
import com.dessert.sys.service.CartService;
 

@Controller
@RequestMapping("/cart/")
public class ShopCartController {
	
	@Autowired
	private CartService cartservice;
	
	@ResponseBody
	@RequestMapping("addcart")
	public JsonResult addcart(Shopcart shopcart){
	 
		cartservice.addCart(shopcart);
		return new JsonResult("加入购物成功");
	}
	@ResponseBody
	@RequestMapping("findcarts")
	public JsonResult findcarts(String username) 
	{ 
	 
		List<Shopcart> carts = cartservice.findShopcarts(username);
		 
		return new JsonResult(carts);
	}
	@ResponseBody
	@RequestMapping("deleteCarts")
	public JsonResult deleteCarts(String username){
		cartservice.deleteCarts(username);
		return new JsonResult("清除成功");
	}
	
}
