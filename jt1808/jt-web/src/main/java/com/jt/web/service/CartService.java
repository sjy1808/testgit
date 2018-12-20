package com.jt.web.service;

import java.util.List;

import com.jt.common.po.Cart;

public interface CartService {

	List<Cart> findCartByUserId(Long userId);

	void updateNumber(Long userId, Long itemId, Integer num);

	void deleteCart(Long userId, Long itemId);

	void saveCart(Cart cart);

}
