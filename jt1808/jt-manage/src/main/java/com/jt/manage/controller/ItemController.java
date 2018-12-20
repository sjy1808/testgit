package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.po.Item;
import com.jt.common.po.ItemDesc;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	public ItemService itemService;
	
	//实现商品信息的展现
	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult findItemByPage(Integer page,Integer rows){
		return itemService.findItemByPage(page,rows);
	}
	
	//通过itemcat的id查询商品分类的名称
	@RequestMapping(value="/cat/queryItemName",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findItemCateNameById(Long itemId){
		return itemService.findItemCateNameById(itemId);
	}
	
	//实现商品的新增
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveItem(Item item,String desc){
		try {
			itemService.saveItem(item, desc);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "新增商品失败!");
	}
	
	//编辑商品的信息
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateItem(Item item,String desc){
		try {
			itemService.updateItem(item,desc);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "编辑商品失败!");
	}
	
	//实现商品的下架
	@RequestMapping("/instock")
	@ResponseBody
	public SysResult instock(Long[] ids){
		try {
			int status=2;//表示下架
			itemService.updateStatus(ids,status);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "下架商品失败!");
	}
	
	//实现商品的上架
	@RequestMapping("/reshelf")
	@ResponseBody
	public SysResult reshelf(Long[] ids){
		try {
			int status=1;//表示上架
			itemService.updateStatus(ids, status);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "上架商品失败!");
	}
	
	//实现商品的删除
	@RequestMapping("/delete")
	@ResponseBody
	public SysResult delete(Long[] ids){
		try {
			itemService.deleteItem(ids);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "删除商品失败!");
	}
	
	//根据商品id查询商品详情
	@RequestMapping("/query/item/desc/{itemId}")
	@ResponseBody
	public SysResult findItemDescById(@PathVariable("itemId")Long itemId){
		try {
			ItemDesc itemDesc = itemService.findItemDescById(itemId);
			return SysResult.oK(itemDesc);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return SysResult.build(201, "编辑商品信息失败!");
	}
}
