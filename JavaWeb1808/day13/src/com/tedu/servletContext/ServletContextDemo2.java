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
public class ServletContextDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取ServletContext对象
		ServletContext context = this.getServletContext();
		
		//2.从ServletContext域中取出数据并打印到控制台上
		System.out.println(context.getAttribute("name"));
		System.out.println(context.getAttribute("age"));
		System.out.println(context.getAttribute("addr"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
