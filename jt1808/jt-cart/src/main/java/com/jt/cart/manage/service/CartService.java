package com.jt.cart.manage.service;

import java.util.List;

import com.jt.common.po.Cart;

public interface CartService {

	List<Cart> findCartByUserId(Long userId);

	void updateNumber(Cart cart);

	void deleteCart(Cart cart);

	void saveCart(Cart cart);

}
