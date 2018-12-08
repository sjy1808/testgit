package com.tedu.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public class TestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url=request.getRequestURI().toString();
		System.out.println("url:"+url);
		String id=request.getRemoteAddr();
		System.out.println("id:"+id);
		String host=request.getHeader("host");
		System.out.println("访问的主机为:"+host);
		String contextPath=request.getContextPath();
		System.out.println("contextPath:"+contextPath);
		String username=request.getParameter("username");
		System.out.println("username:"+username);
		String[] likes=request.getParameterValues("like");
		System.out.println(Arrays.toString(likes));
		String nickname=request.getParameter("nickname");
		System.out.println("nickname:"+nickname);
		
		//request:将数据存入Request域中
		request.setAttribute("url", url);
		request.setAttribute("id", id);
		request.setAttribute("host", host);
		request.setAttribute("username",username );
		request.setAttribute("likes",Arrays.toString(likes));
		request.setAttribute("nickname",nickname);
		
		//转发:将请求转发到JSP中,让JSP来处理及展示结果
		request.getRequestDispatcher("/index.jsp").forward(request, response);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

