package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.manage.service.ItemCatService;
import com.jt.manage.vo.EasyUITree;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	/**
	 * 
	 * @param ParentId
	 * @RequestParam(value="",defaultValue="",required=true)Long ParentId
	 * value="接收参数的名称"
	 * defaultValue="可以设定一个默认值"
	 * required=true 该属性必须传递
	 * @return
	 */
	//根据商品parentId查询商品分类信息
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITree> findItemCatByParentId(@RequestParam(value="id",defaultValue="0",required=true)Long parentId){
		//1.实现查询一级商品分类的信息
		//Long parentId=0L;
		//return itemCatService.findItemCatList(parentId);
		//实现缓存
		return itemCatService.findCatchList(parentId);
	}
}
