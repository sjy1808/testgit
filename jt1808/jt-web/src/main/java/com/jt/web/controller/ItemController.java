package com.jt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.web.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	//查询商品的信息 ,之后进行页面的展现
	@RequestMapping("/{itemId}")
	public String findItemById(@PathVariable Long itemId,Model model){
		Item item=itemService.findItemById(itemId);
		model.addAttribute("item",item);
		//查询商品详情信息
		ItemDesc itemDesc=itemService.findItemDescById(itemId);
		model.addAttribute("itemDesc",itemDesc);
		return "item";
	}
	
}
