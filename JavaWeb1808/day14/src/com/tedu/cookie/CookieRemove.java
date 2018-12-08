package com.tedu.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *删除名称为time的cookie 
 */
public class CookieRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.创建一个名称为time的cookie
		Cookie cookie=new Cookie("time","");
		//2.设置cookie的存活时间
		cookie.setMaxAge(0);
		//3.将cookie添加到响应中发送给浏览器
		response.addCookie(cookie);
		response.getWriter().write("Cookie Remove!!");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
