package com.jt.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.CheckBox;
import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.SysUserService;
import com.jt.sys.vo.SysUserDeptResult;

@Controller
@RequestMapping("/user/")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	@RequestMapping("doUserListUI")
	public String doUserListUI(){
		return "sys/user_list";
	}
	@RequestMapping("doUserEditUI")
	public String doUserEditUI(){
		return "sys/user_edit";
	}
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
		String username,Integer pageCurrent){
		PageObject<SysUserDeptResult> pageObject=
		sysUserService.findPageObjects(username,
				pageCurrent);
		return new JsonResult(pageObject);
	}
	/**禁用和启用用户状态*/
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(
			Integer id,
			Integer valid){
		SysUser user=(SysUser)SecurityUtils.getSubject().getPrincipal();
		        sysUserService.validById(
				id,
				valid, 
				user.getUsername());//"admin"用户将来是登陆用户
		return new JsonResult("update ok");
	}
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		List<CheckBox> checkbox = sysUserService.findObjects();
		return new JsonResult(checkbox);
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysUser entity,Integer... roleIds){
		System.out.println(entity);
		sysUserService.saveObject(entity, roleIds);
		return new JsonResult("save ok");
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	                  
	public JsonResult doFindObjectById(Integer userId){
		System.out.println(userId);
		Map<String, Object> map = sysUserService.findObjectById(userId);
		return new JsonResult(map);
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysUser entity,Integer[] roleIds){
		sysUserService.updateObject(entity, roleIds);
		return new JsonResult("update Ok");
	}
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,String password){
		//1.对用户进行封装
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		//2.提交用户信息到SecurityManager
		//2.1获取用户主体对象
		Subject subject = SecurityUtils.getSubject();
		//2.2提交用户信息
		subject.login(token);
		return new JsonResult("login ok");
	}


}
