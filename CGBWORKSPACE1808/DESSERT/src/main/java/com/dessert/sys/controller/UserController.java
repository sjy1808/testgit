package com.dessert.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dessert.common.vo.JsonResult;
import com.dessert.sys.orders.entity.User;
import com.dessert.sys.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("doUserListUI")
	public String doUserListUI() {
		return "sys/user_list";
	}

	@RequestMapping("doUserEditUI")
	public String doUserEditUI() {
		return "sys/user_edit";
	}
	@RequestMapping("doFindObjectByUsername")
	@ResponseBody
	public JsonResult doFindObjectByUsername(String username){
		System.out.println(username);
		User user = userService.findObjectByUsername(username);
		System.out.println(user.toString());
		return new JsonResult(user);
	}
	
	
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username, String password) {
		// 1.获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		// 2.通过Subject提交用户信息,交给shiro框架进行认证操作
		// 2.1对用户进行封装
		UsernamePasswordToken token = new UsernamePasswordToken(username, // 身份信息
				password);// 凭证信息
		System.out.println(token.toString());
		// 2.2对用户信息进行身份认证
		subject.login(token);
		// 分析:
		// 1)token会传给shiro的SecurityManager
		// 2)SecurityManager将token传递给认证管理器
		// 3)认证管理器会将token传递给realm
		return new JsonResult("login ok");
	}

	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(Integer id) {
		User user = userService.findObject(id);
		return new JsonResult(user);
	}

	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(User entity) {
		userService.updateObject(entity);
		return new JsonResult("update ok");
	}

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(User entity) {
		System.out.println(entity);
		userService.saveObject(entity);
		return new JsonResult("save ok");
	}


	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		return new JsonResult(userService.findPageObjects(username, pageCurrent));
	}

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer id) {
		userService.deleteObjects(id);
		return new JsonResult("delete ok");
	}

}