package com.dessert.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dessert.common.vo.JsonResult;
import com.dessert.common.vo.PageObject;
import com.dessert.sys.orders.entity.SysGoods;
import com.dessert.sys.service.GoodsService;

@Controller
@RequestMapping("/goods/")
public class GoodsContraller {

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("doGoodUI")
	public String doGoodUI() {
		return "Goods/goods_list";
	}

	@RequestMapping("dofindPageObjects")
	@ResponseBody
	public JsonResult dofindPageObjects(String name, Integer pageCurrent) {
		// System.out.println(name);
		PageObject<SysGoods> page = goodsService.findPageObjects(name, pageCurrent);
		return new JsonResult(page);
	}

	@RequestMapping("dofindPageObjectsCategory")
	@ResponseBody
	public JsonResult dofindPageObjectsCategory(String category) {
		// System.out.println(name);
		System.out.println(category);
		PageObject<SysGoods> page = goodsService.findPageObjectsCategory(category);
		return new JsonResult(page);
	}

	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		goodsService.deleteObject(id);
		return new JsonResult("delete Ok");
	}

	@RequestMapping("doGoodsEditUI")
	public String doGoodsEditUI() {
		return "Goods/goods_edit";
	}

	@RequestMapping("dosaveObject")
	@ResponseBody
	public JsonResult dosaveObject(SysGoods entity) {
		// System.out.println(entity);
		goodsService.saveObject(entity);
		return new JsonResult("save OK");
	}

	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		// System.out.println(id);
		Map<String, Object> map = goodsService.findObjectById(id);
		return new JsonResult(map);
	}

	@ResponseBody
	@RequestMapping("doUpdataObject")
	public JsonResult doUpdataObject(SysGoods entity) {
		goodsService.updateObject(entity);
		return new JsonResult("update OK");
	}

}
