package com.jt.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.Node;
import com.jt.sys.service.SysDeptService;

@Controller
@RequestMapping("/dept/")
public class SysDeptController {
	
	@Autowired
	private SysDeptService sysDeptService;
	
	@RequestMapping("doDeptListUI")
	public String doDeptListUI(){
		return "sys/dept_list";
	}
	@RequestMapping("doDeptEditUI")
	public String doDeptEditUI(){
		return "sys/dept_edit";
	}
	
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		return new JsonResult(sysDeptService.findObjects());
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysDeptService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	@RequestMapping("doFindZtreeDeptNodes")
	@ResponseBody
	public JsonResult doFindZtreeDeptNodes(){
		List<Node> nodes = sysDeptService.findZtreeDeptNodes();
		return new JsonResult(nodes);
	}
}
