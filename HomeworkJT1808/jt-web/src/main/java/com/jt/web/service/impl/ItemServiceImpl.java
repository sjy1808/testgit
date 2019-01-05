package com.jt.web.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.common.service.HttpClientService;
import com.jt.web.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private HttpClientService httpClientService;
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	/**
	 * 1.定义url地址
	 * 2.封装参数
	 * 3.发起请求,解析返回值结果
	 */
	@Override
	public Item findItemById(Long itemId) {
		String url="http://manage.jt1.com/web/item/findItemById";
		Map<String,String> params=new HashMap<>();
		params.put("itemId", itemId+"");
		String itemJSON = httpClientService.doGet(url,params);
		Item item=null;
		try {
			//将json转化为对象
			item=objectMapper.readValue(itemJSON, Item.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public ItemDesc findItemDescById(Long itemId) {
		String url="http://manage.jt1.com/web/item/findItemDescById/"+itemId;
		String itemDescJSON=httpClientService.doGet(url);
		ItemDesc itemDesc=null;
		try {
			itemDesc=objectMapper.readValue(itemDescJSON, ItemDesc.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return itemDesc;
	}

}
