package com.jt.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.cart.mapper.CartMapper;
import com.jt.cart.service.CartService;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
}
