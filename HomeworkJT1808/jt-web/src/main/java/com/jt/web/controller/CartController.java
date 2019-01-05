package com.jt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.common.po.Cart;
import com.jt.web.service.CartService;
import com.jt.web.thread.UserThreadLocal;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	//跳转到购物车页面
	@RequestMapping("/show")
	public String findCartByUserId(Model model){
		Long userId=UserThreadLocal.get().getId();
		List<Cart> cartList=cartService.findCartByUserId(userId);
		model.addAttribute("cartList",cartList);
		return "cart";
	}
}
