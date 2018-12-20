package com.jt.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.po.User;
import com.jt.common.vo.SysResult;
import com.jt.web.service.UserService;

import redis.clients.jedis.JedisCluster;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JedisCluster jedisCluster;
	///user/login.html
	@RequestMapping("/{moduleName}")
	public String toModule(@PathVariable String moduleName){
		return moduleName;
	}
	//实现用户注册
	@RequestMapping("/doRegister")
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
	
	//实现用户的登录
	@RequestMapping("/doLogin")
	@ResponseBody
	public SysResult findUserByUP(User user,HttpServletResponse response){
		try {
			
			//获取后台返回的秘钥
			String token=userService.findUserByUP(user);
			//返回值的数据不为空,将token的数据写入cookie中
			if(!StringUtils.isEmpty(token)){
				Cookie cookie=new Cookie("JT_TICKET",token);
				cookie.setMaxAge(7*24*3600);//让cookie存活7天
				cookie.setPath("/");//访问cookie的权限
				response.addCookie(cookie);
				return SysResult.oK();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "用户登录失败!");
	}
	
	/**
	 * 1.从cookie中动态获取jt_ticket的值,之后进行删除 
	 * 2.删除redis
	 * 3.删除cookie 为cookie设值最大生命周期为0 setPath("/")
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		//1.获取Cookie数据
		Cookie[] cookies=request.getCookies();
		String token=null;
		for (Cookie cookie : cookies) {
			if("JT_TICKET".equals(cookie.getName())){
				token=cookie.getValue();
				break;//停止循环
			}
		}
		//获取token,删除redis
		jedisCluster.del(token);
		
		//删除Cookie
		Cookie cookie = new Cookie("JT_TICKET","");//有些浏览器对null兼容性不好,尽量使用""
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	
		//页面应该如何跳转   跳转到系统首页
		return "redirect:/index.html";
	}
}