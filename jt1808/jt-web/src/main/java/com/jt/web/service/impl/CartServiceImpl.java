package com.jt.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.po.Cart;
import com.jt.common.po.Item;
import com.jt.common.service.HttpClientService;
import com.jt.common.vo.SysResult;
import com.jt.web.service.CartService;
import com.jt.web.service.ItemService;
@Service
public class CartServiceImpl implements CartService {

	//获取商品信息
	@Autowired
	private ItemService itemService;
	@Autowired
	private HttpClientService httpClient;
	private ObjectMapper objectMapper=new ObjectMapper();
	@Override
	public List<Cart> findCartByUserId(Long userId) {
		//通过RESTFul风格进行数据交换
		String url="http://cart.jt.com/cart/query/"+userId;
		String sysJSON=httpClient.doGet(url);
		List<Cart> cartList=null;
		try {
			//将json转化为SYSResult对象
			SysResult sysResult = objectMapper.readValue(sysJSON, SysResult.class);
			if(sysResult.getStatus()==200){
				//证明后台返回数据成功
				cartList=(List<Cart>) sysResult.getData();
			}
			//如果状态为201时,表示后台查询数据为null,需要告知用户服务器异常,请稍后重试     后期维护
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}
	@Override
	public void updateNumber(Long userId, Long itemId, Integer num) {
		String url="http://cart.jt.com/cart/update/num/"+userId+"/"+itemId+"/"+num;
		httpClient.doGet(url);
	}
	@Override
	public void deleteCart(Long userId, Long itemId) {
		String url="http://cart.jt.com/cart/delete/"+userId+"/"+itemId;
		httpClient.doGet(url);
	}
	
	/**
	 * 可以通过数据的替换,会将商品的价格进行修改,所以不能使用前台提交过来的数据进行入库操作
	 * 应该再次查询数据库商品的价格信息
	 */
	@Override
	public void saveCart(Cart cart) {
		//获取真实的商品信息  一般前台查询的商品都会保存到缓存中
		Item item=itemService.findItemById(cart.getItemId());
		cart.setItemPrice(item.getPrice());
		//定义url请求
		String url="http://cart.jt.com/cart/save";
		//将数据封装为json
		try {
			String cartJSON = objectMapper.writeValueAsString(cart);
			Map<String,String> params=new HashMap<>();
			params.put("cartJSON", cartJSON);
			httpClient.doPost(url,params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
