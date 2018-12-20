package com.jt.cart.manage.mapper;

import com.jt.common.mapper.SysMapper;
import com.jt.common.po.Cart;

public interface CartMapper extends SysMapper<Cart> {

	void updateNum(Cart cart);

	Cart findCartByUI(Cart cart);

}