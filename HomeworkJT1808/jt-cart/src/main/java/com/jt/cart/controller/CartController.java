package com.jt.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jt.cart.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
}
