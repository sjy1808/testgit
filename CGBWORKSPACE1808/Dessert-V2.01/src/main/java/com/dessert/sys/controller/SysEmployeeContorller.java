package com.dessert.sys.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dessert.common.vo.JsonResult;
import com.dessert.common.vo.PageObject;
import com.dessert.sys.entity.SysEmployee;
import com.dessert.sys.service.SysEmployeeService;
import com.dessert.sys.vo.SysEmployeeDeptResult;

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
		PageObject<SysEmployeeDeptResult> pageObject = sysEmployeeService.findPageObjects(name, pageCurrent);
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
		SysEmployeeDeptResult object = sysEmployeeService.findObjectById(id);
		return new JsonResult(object);
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysEmployee entity){
		System.out.println(entity);
		sysEmployeeService.updateObject(entity);
		return new JsonResult("update ok");
	}
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,String password){
		//1.获取Subject对象
		Subject subject=SecurityUtils.getSubject();
		//2.通过Subject提交员工信息,交给shiro框架进行认证操作
		//2.1对员工进行封装
		UsernamePasswordToken token = new UsernamePasswordToken(
				username,//身份信息
				password);//凭证信息
		//2.2对员工信息进行身份认证
		subject.login(token);
		//1)token会传给shiro的SecurityManager
		//2)SecurityManager将token传递给认证管理器
		//3)认证管理器会将token传递给realm
		/*Session session = subject.getSession();
		session.setAttribute("session", session);*/
		return new JsonResult("login ok");

	}
}
