package com.tedu.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现请求重定向
 * 实现定时刷新
 */
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ResponseDemo2.doGet()");
		//1.重定向到当前Web应用下的index.html
		//response.sendRedirect("/day13/index.html");
		
		//2.重定向到day11应用下的regist.html(不同的包)
		//response.sendRedirect("/day11/regist.html");
		
		//3.重定向到tmooc的首页(不同的虚拟主机)
		//response.sendRedirect("http://www.tmooc.cn");
		
		/*
		 * 定时刷新:和重定向的最大区别在于定时刷新是指定多少秒之后再进行跳转,重定向是立即跳转!!
		 */
		//1.定时刷新到当前Web应用下的index.html
		/*response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("10秒之后将会跳转到首页...");
		response.setHeader("Refresh","10;url=/day13/index.html");*/
		//2.定时刷新到day11应用下的regist.html(不同的包)
		/*response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("3秒之后将会跳转到首页...");
		response.setHeader("Refresh","3;url=/day11/regist.html");*/
		//3.定时刷新到tmooc的首页(不同的虚拟主机)
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("3秒之后将会跳转到主页...");
		response.setHeader("Refresh","3;url=http://www.tmooc.cn");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
