package com.tedu.request;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Request功能二:获取请求参数
 */
public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 如果请求方式是post提交,参数乱码问题一行代码搞定!
		 */
		request.setCharacterEncoding("utf-8");
		//1.getParameter
		String username=request.getParameter("username");//å¼ é£
		System.out.println("username:"+username);
		
		//2.getParameterValues
		String[] likes=request.getParameterValues("like");
		System.out.println(Arrays.toString(likes));
		
		//通过手动编解码处理乱码(对GET和POST都好使!!)
		byte[] bytes = username.getBytes("iso8859-1");
		username=new String(bytes,"utf-8");
		System.out.println("username="+username);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

