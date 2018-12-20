package com.jt.cart.manage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.cart.manage.mapper.CartMapper;
import com.jt.cart.manage.service.CartService;
import com.jt.common.po.Cart;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<Cart> findCartByUserId(Long userId) {
		Cart cart=new Cart();
		cart.setUserId(userId);
		List<Cart> listCard=cartMapper.select(cart);
		return listCard;
	}

	//能否使用通用Mapper实现                不能  因为没有主键
	@Override
	public void updateNumber(Cart cart) {
		cart.setUpdated(new Date());
		cartMapper.updateNum(cart);
	}

	@Override
	public void deleteCart(Cart cart) {
		//删除购物车数据userId和itemId
		cartMapper.delete(cart);
	}
	
	/**
	 * 业务思路:
	 * 	通过itemId和userId唯一确定一条购物信息,
	 * 	数据库中不允许出现重复数据
	 * 1.现根据itemId和userId查询数据库
	 * 2.如果数据为null,则直接入库
	 * 3.如果数据不为null,表示用户已新增过该商品信息则跟新商品数量即可
	 */
	@Override
	public void saveCart(Cart cart) {
		Cart cartDB=cartMapper.findCartByUI(cart);
		if(cartDB==null){
			cart.setCreated(new Date());
			cart.setUpdated(cart.getCreated());
			cartMapper.insert(cart);
		}else{
			int num=cart.getNum()+cartDB.getNum();
			cartDB.setNum(num);
			cartDB.setUpdated(new Date());
			cartMapper.updateByPrimaryKeySelective(cartDB);
		}
	}
}
