package com.tedu.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 案例:在网页中显示上一次访问的时间
 */
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取本次访问时间
		String date1=new Date().toLocaleString();
		//2.将本次访问的时间通过cookie发送给浏览器保存
		//Cookie cookie=new Cookie("time",date1);
		Cookie cookie=new Cookie("time",URLEncoder.encode(date1,"utf-8"));
		
		/*
		 * 设置cookie的最大存活时间,即使浏览器多次开关,cookie也可以一直存在,不受浏览器开关的影响!*/
		cookie.setMaxAge(60*60*24*30);//cookie存活一个月
		
		response.addCookie(cookie);
		
		
		//3.获取上次访问的时间
		Cookie[] cs=request.getCookies();//获取所有cookie对象数组
		String dateStr2=null;
		//遍历cookie对象数组,查找名称为time的cookie
		if(cs!=null){
			for(Cookie c:cs){
				if("time".equals(c.getName())){
					//获取cookie中保存的上次访问的时间
					//dateStr2=c.getValue();
					dateStr2=URLDecoder.decode(c.getValue(),"utf-8");
				}
			}
		}
		//4.将上次访问时间发送给浏览器显示在网页上
		response.setContentType("text/html;charset=utf-8");
		if(dateStr2!=null){//不是第一次
			response.getWriter().write("您上次访问的时间为:"+dateStr2);
		}else{
			response.getWriter().write("您是第一次访问本网站!");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
