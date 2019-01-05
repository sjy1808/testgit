package com.jt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.web.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	//查询商品信息,之后进行页面展现
	@RequestMapping("/{itemId}")
	@ResponseBody
	public String findItemById(@PathVariable Long itemId,Model model){
		Item item=itemService.findItemById(itemId);
		model.addAttribute(item);
		
		//实现商品详情回显
		ItemDesc itemDesc=itemService.findItemDescById(itemId);
		model.addAttribute(itemDesc);
		return "item";
	}
}
