package com.jt.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.common.po.User;
import com.jt.common.vo.SysResult;
import com.jt.sso.service.UserService;

import redis.clients.jedis.JedisCluster;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JedisCluster jedisCluster;
	
	//基于jsonp实现用户校验
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public JSONPObject findCheckUser(@PathVariable String param,@PathVariable Integer type,String callback){
		Boolean flag=userService.findCheckUser(param,type);
		return new JSONPObject(callback,SysResult.oK(flag));
	}
	@RequestMapping("/register")
	@ResponseBody
	public SysResult saveUser(User user){
		try {
			userService.saveUser(user);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "用户新增失败!");
	}
	
	//实现sso后台用户登录
	@RequestMapping("/login")
	@ResponseBody
	public SysResult findUserByUP(User user){
		try {
			String token=userService.findUserByUP(user);
			if(!StringUtils.isEmpty(token)){
				//保证后台调用不错
				return SysResult.oK(token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201,"用户查询失败!");
	}
	
	//JSONP 根据token数据查询用户信息
	@RequestMapping("/query/{token}")
	@ResponseBody
	public JSONPObject findUserByToken(@PathVariable String token,String callback){
		String userJSON=jedisCluster.get(token);
		return new JSONPObject(callback,SysResult.oK(userJSON));
	}
	
	
}
