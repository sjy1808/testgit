package com.dessert.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dessert.common.vo.JsonResult;
import com.dessert.common.vo.PageObject;
import com.dessert.sys.entity.SysEmployee;
import com.dessert.sys.service.SysEmployeeService;

@Controller
@RequestMapping("/employee/")
public class SysEmployeeContorller {

	@Autowired
	private SysEmployeeService sysEmployeeService;
	@RequestMapping("doEmployeeListUI")
	public String doEmployeeListUI(){
		return "sys/employee_list";
	}
	@RequestMapping("doEmployeeEditUI")
	public String doEmployeeEditUI(){
		return "sys/employee_edit";
	}
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name,Integer pageCurrent){
		PageObject<SysEmployee> pageObject = sysEmployeeService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysEmployee entity){
		System.out.println("entity="+entity);
		sysEmployeeService.saveObject(entity);
		return new JsonResult("save ok");
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysEmployeeService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		List<SysEmployee> object = sysEmployeeService.findObjectById(id);
		return new JsonResult(object);
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysEmployee entity){
		System.out.println(entity);
		sysEmployeeService.updateObject(entity);
		return new JsonResult("update ok");
	}
}
