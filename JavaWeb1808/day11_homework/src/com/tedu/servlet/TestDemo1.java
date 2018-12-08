package com.tedu.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public class TestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		System.out.println("url:"+url);
		
		String id=request.getRemoteAddr();
		System.out.println("id:"+id);
		
		String path=request.getContextPath();
		System.out.println("contextPath:"+path);
		
		String host=request.getHeader("host");
		System.out.println("访问的主机为:"+host);
		
		String username=request.getParameter("username");
		System.out.println("username:"+username);
		byte[] bytes=username.getBytes("iso8859-1");
		username=new String(bytes,"utf-8");
		System.out.println("username1:"+username);
		String nickname=request.getParameter("nickname");
		byte[] bytes1=nickname.getBytes("iso8859-1");
		nickname=new String(bytes1,"utf-8");
		System.out.println("nickname:"+nickname);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
