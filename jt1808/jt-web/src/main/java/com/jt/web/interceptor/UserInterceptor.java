package com.jt.web.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.po.User;
import com.jt.web.thread.UserThreadLocal;

import redis.clients.jedis.JedisCluster;

//定义用户的拦截器,使用用户登录的判断
//handler处理器    处理器完成了 什么工作?
/**
 * 
 * @author Administrator
 *
 */
public class UserInterceptor implements HandlerInterceptor {

	@Autowired
	private JedisCluster jedisCluster;
	
	private ObjectMapper objectMapper=new ObjectMapper();
	//在controller方法执行之前
	/**
	 * 设计思路:
	 * 	通过拦截器定义,如果用户没有登录,则跳转到登录页面
	 * 	如果用户已经登录了,则跳转到目标页面
	 * 
	 * 判断依据:
	 * 	Cookie中token名称为TICKET
	 * 	通过TICKET查询redis中是否有数据
	 * 	如果redis中有数据,则表示用户一定登陆过,则跳转到目标页面
	 * 
	 * 用户信息共享的优化
	 * 	如果需要获取用户信息,可以通过session动态获取
	 * 	但是程序在取值时,必须传递HttpServletRequest
	 * 	如果在service层/mapper层需要动态获取user数据
	 * 使用ThreadLocal方式动态获取数据
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1.获取Cookie中的数据
		Cookie[] cookies = request.getCookies();
		String token=null;
		for (Cookie cookie : cookies) {
			if("JT_TICKET".equals(cookie.getName())){
				token=cookie.getValue();
				break;
			}
		}
		
		//需要对token进行判断 是否为空
		if(!StringUtils.isEmpty(token)){
			//2.判断redis中是否有数据
			String userJSON = jedisCluster.get(token);
			if(!StringUtils.isEmpty(userJSON)){
				//表示用户已经登录
				User user=objectMapper.readValue(userJSON,User.class);
				//1.将对象保存到session中
				request.getSession().setAttribute("JT_USER", user);
				//2.为了业务层调用方便,使用ThreadLocal保存数据
				UserThreadLocal.set(user);
				return true;//表示拦截方向
			}
		}
		//重定向到用户登录页面
		response.sendRedirect("/user/login.html");
		return false;//表示拦截,需要添加转向的操作
	}

	//在controller方法执行之后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	//在用户响应页面之前
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//防止内存泄露
		UserThreadLocal.remove();
	}

}
