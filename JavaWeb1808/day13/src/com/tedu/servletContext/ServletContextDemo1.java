package com.tedu.servletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
public class ServletContextDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取ServletContext对象
		ServletContext context=this.getServletContext();
		
		//2.往ServletContext域中存入数据
		context.setAttribute("name","阿凡提");
		context.setAttribute("age","45");
		context.setAttribute("addr","北京");
		
		System.out.println("数据已存入ServletContext域中...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
