package com.tedu.service;

public class CartServiceImpl implements CartService {

	@Override
	public String findCartByUserId(Long userId) {
		return "第二个提供者  cart userId="+userId;
	}

}
