package com.jt.cart.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.cart.manage.service.CartService;
import com.jt.common.po.Cart;
import com.jt.common.vo.SysResult;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	private ObjectMapper objectMapper=new ObjectMapper();
	//根据用户id查询购物车信息
	//http://cart.jt.com/cart/query/{userId}
	@RequestMapping("/query/{userId}")
	@ResponseBody
	public SysResult findCartByUserId(@PathVariable Long userId){
		try {
			List<Cart> cartList=cartService.findCartByUserId(userId);
			if(cartList!=null){
				return SysResult.oK(cartList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "获取购物车信息失败!");
	}
	//修改购物车数量
	//http://cart.jt.com/cart/update/num/{userId}/{itemId}/{num}
	@RequestMapping("/update/num/{userId}/{itemId}/{num}")
	@ResponseBody
	public SysResult updateNumber(@PathVariable Long userId,@PathVariable Long itemId,@PathVariable Integer num){
		try {
			Cart cart=new Cart();
			cart.setUserId(userId);
			cart.setItemId(itemId);
			cart.setNum(num);
			cartService.updateNumber(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "修改购物车数量失败");
	}
	
	//删除购物车信息
	//http://cart.jt.com/cart/delete/{userId}/{itemId}
	@RequestMapping("/delete/{userId}/{itemId}")
	@ResponseBody
	public SysResult deleteCart(@PathVariable Long userId,@PathVariable Long itemId){
		try {
			Cart cart = new Cart();
			cart.setUserId(userId);
			cart.setItemId(itemId);
			cartService.deleteCart(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "购物车删除失败!");
	}
	
	//新增购物车
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveCart(String cartJSON){
		try {
			Cart cart = objectMapper.readValue(cartJSON, Cart.class);
			cartService.saveCart(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "新增购物车失败!");
	}
}